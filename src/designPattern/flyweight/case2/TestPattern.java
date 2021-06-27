package designPattern.flyweight.case2;

public class TestPattern {
    public static void main(String[] args) {
        MyData myData = new MyData();
        myData.xpos = 10;
        myData.ypos = 11;
        myData.name = "홍길동";

        MyData myData2 = new MyData();
        //얕은 복사의 경우 flyweight
        myData2 = myData;

        MyData myData3 = new MyData();
        myData3.xpos = 20;
        myData3.ypos = 21;
        myData3.name = "홍길동";

        if(myData3.name == myData.name){
            System.out.println("객체 내의 String도 같을까");
        }
        else
            System.out.println("객체 내의 String은 다르다.");

        // 같은 객체를 바라보고 있기 때문에 myData, myData2 같이 수정
        myData2.name = "전우치";
        myData2.xpos = 5;



    }
}

class MyData{
    int xpos;
    int ypos;
    String name;
}
