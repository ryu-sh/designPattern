package designPattern.flyweight.case1;

public class TestPattern {
    public static void main(String[] args) {
        String str1 = new String("홍길동");
        String str2 = new String("홍길동");
        String str3 = "홍길동";
        String str4 = "홍길동";

        if(str3 == str4){
            System.out.println("str3, str4 같은 객체");
        }

        if(str1 == str2){
            System.out.println("str1, str2 같은 객체");
        }
        else
            System.out.println("str1, str2 다른 객체");

        if(str1 == str3){
            System.out.println("str1, str3 같은 객체");
        }
        else
            System.out.println("str1, str3 다른 객체");
    }
}
