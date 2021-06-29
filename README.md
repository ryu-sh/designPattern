# desingPattern

### 목차
[1.](#sigleton-pattern) sigleton pattern  
[2.](#flyweight-pattern) flyweight pattern  
[3.](#observer-pattern) observer pattern

## sigleton pattern
 - 전역 변수를 사용하지 않고 객체를 하나만 생성 하도록 하며, 생성된 객체를 어디에서든지 참조할 수 있도록 하는 패턴
 - 하나의 인스턴스만을 생성하는 책임이 있으며 getInstance 메서드를 통해 모든 클라이언트에게 동일한 인스턴스를 반환하는 작업을 수행한다

문제점
 - 경합 조건(Race Condition) 을 발생시키는 경우
    - 인스턴스가 아직 생성되지 않았을 때 스레드 1이 getInstance 메서드의 if문을 실행해 이미 인스턴스가 생성되었는지 확인한다. 현재 객체 변수는 null인 상태다.
만약 스레드 1이 생성자를 호출해 인스턴스를 만들기 전 스레드 2가 if문을 실행해 객체 변수가 null인지 확인한다. 현재 객체 변수는 null이므로 인스턴스를 생성하는 생성자를 호출하는 코드를 실행하게 된다.
스레드 1도 스레드 2와 마찬가지로 인스턴스를 생성하는 코드를 실행하게 되면 결과적으로 객체 클래스의 인스턴스가 2개 생성된다.
- 경합 조건이란?
    - 메모리와 같은 동일한 자원을 2개 이상의 스레드가 이용하려고 경합하는 현상

해결점
- 다중 스레드 애플리케이션이 아닌 경우에는 아무런 문제가 되지 않는다.

다중 스레드 애플리케이션에서 발생하는 문제를 해결하는 방법
1. 정적 변수에 인스턴스를 만들어 바로 초기화하는 방법 (Eager Initialization)
  - 객체가 생성되기 전 클래스가 메모리에 로딩될 때 만들어져 초기화가 한 번만 실행된다.
  - 프로그램 시작~종료까지 없어지지 않고 메모리에 계속 상주하며 클래스에서 생성된 모든 객체에서 참조할 수 있다.
2. 인스턴스를 만드는 메서드에 동기화(synchronized)하는 방법 (Thread-Safe Initialization)
  - 다중 스레드 환경에서 동시에 여러 스레드가 getInstance 메서드를 소유하는 객체에 접근하는 것을 방지한다.
  - 공유 변수(객체 property)에 접근하는 부분을 임계 구역으로 변경
    - 여러 개의 스레드가 하나뿐인 counter 변수 값에 동시에 접근해 갱신하는 것을 방지한다.
  - getInstance()에 Lock을 하는 방식이라 속도가 느리다.(비용이 비쌈. 병목현상이 일어남.)

예제 : https://github.com/ryu-sh/desingPattern/tree/master/src/designPattern/singleton

## flyweight pattern
 - Flyweight 패턴은 비용이 큰 자원을 공통으로 사용할 수 있도록 만드는 패턴이다. 자원에 대한 비용은 크게 두가지로 나눠 볼 수 있다.
1. 중복 생성될 가능성이 높은 경우
 - 중복 생성될 가능성이 높다는 것은 동일한 자원이 자주 사용될 가능성이 매우 높다는 것을 의미한다. 이런 자원은 공통 자원 형태로 관리하고 있다가 요청이 있을 때 제공해 주는 편이 좋다.

2. 자원 생성 비용은 큰데 사용 빈도가 낮은 경우
 - 이런 자원을 항상 미리 생성해 두는 것은 낭비이다. 따라서 요청이 있을 때에 생성해서 제공해 주는 편이 좋다

이 두가지 목적을 위해서 Flyweight 패턴은 자원 생성과 제공을 책임진다. 자원의 생성을 담당하는 Factory 역할과 관리 역할을 분리하는 것이 좋을 수 있으나, 일반적으로는 두 역할의 크기가 그리 크지 않아서 하나의 클래스가 담당하도록 구현한다.

Flyweight 패턴은 실제 여러 곳에서 사용된다. 쓰레드 풀이나 객체 재사용 풀도 일종의 Flyweight 패턴이다. 

Java 라이브러리들 중에서도 이를 사용하는데, 매우 사용 빈도가 높은 Integer 클래스에도 이와 같은 패턴이 적용되어 있다.아래는 Integer 클래스에서 사용하는 Flywight 패턴의 코드이다.

```java
private static class IntegerCache {
    static final int low = -128;
    static final int high;
    static final Integer cache[];
    static { // static으로 실행되기 때문에 실행 이전에 생성이 완료됨.
        // high value may be configured by property
        int h = 127;
        String integerCacheHighPropValue =
                sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        if (integerCacheHighPropValue != null) {
            try {
                int i = parseInt(integerCacheHighPropValue);
                i = Math.max(i, 127);
                // Maximum array size is Integer.MAX_VALUE
                h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
            } catch( NumberFormatException nfe) {
                // If the property cannot be parsed into an int, ignore it.
            }
        }
        high = h;
        cache = new Integer[(high - low) + 1]; // Flyweight 생성 부분
        int j = low;
        for(int k = 0; k < cache.length; k++)
            cache[k] = new Integer(j++);
        // range [-128, 127] must be interned (JLS7 5.1.7)
        assert IntegerCache.high >= 127;
    }
    private IntegerCache() {}
}
public static Integer valueOf(int i) {  // Flyweight 객체 제공 부분
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
} 
```
이 소스에서는 IntegerCache라는 static 클래스를 통해서 Integer의 일정 범위를 미리 생성해 둔다. 

전체 범위는 VM(Virtual Machine)에 따라서 달라질 수 있음을 알 수 있다. 하지만 보통은 -128에서 127까지 범위의 Integer 클래스를 배열 형식으로 만들어 둔다. 

그리고 valueOf() 메소드가 호출 되었을 때 요청된 Integer 값이 -128에서 127 사이라면 이미 생성된 Integer 객체를 반환해 준다. 

이 코드는 jre1.8.0_91 기준으로 Integer 클래스의 780 ~833 번째 라인에 들어 있는 코드이다.

예제 : https://github.com/ryu-sh/desingPattern/tree/master/src/designPattern/flyweight

## observer pattern

- 객체 사이에 일 대 다의 의존 관계를 정의해 두어, 어떤 객체의 상태가 변할 때 그 객체에 의존성을 가진 다른 객체들이 그 변화를 통지받고 자동으로 갱신될 수 있게 만든다.
- Subject에 여러 Observer를 등록(Attach)해 두고, Notify를 하게 되면 루프를 돌면서 각 Observer를 Update하는 패턴이다.

![](https://johngrib.github.io/post-img/observer-pattern/structure.jpg)

### 고려할점
 - Notify를 누가 호출해야 할까?
  - Subject 에서 변경이 발생할 때, 변경을 저장하는 메소드가 Notify()를 호출하는 방법.
  - 사용자(main 등)가 적절한 시기에 Notify()를 호출하는 방법.
 - Observer의 행위가 Subject에 영향을 주는 경우
  - 만약 Observer의 행위가 Subject에 영향을 주는 로직이 있다면, 무한 루프가 발생할 수 있으므로 주의할 필요가 있다.

### Java 내장 Observable, Observer deprecated 이유
 - Observable이 interface가 아니라 class이다.
   -  인터페이스에 맞춰 프로그래밍한다는 객체지향 디자인 원칙을 위배한다.
   -  이미 다른 클래스를 상속하는 클래스가 Observable을 상속할 수 없다.
   -  따라서 재사용성에 제약이 생긴다.
 - 상속 위주로 작업을 하게 된다.
   - Observable을 사용하려면 서브 클래스를 만들어야 한다.
   - Observable 내부에 protected 메소드가 있어, Observable의 서브클래스를 인스턴스 변수로 사용하는 방법도 써먹을 수가 없다.
   - 상속보다 구성을 사용한다는 디자인 원칙을 위배한다.
 - Observable이 java.util에 들어있기 때문에 재구현을 할 수 없다. 

### 사용 되는 곳
 - Java Swing 등의 GUI 프레임워크
   - 다양한 버튼과 리스너들(Observer)

예제 : https://github.com/ryu-sh/desingPattern/tree/master/src/designPattern/observer
