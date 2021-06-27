package designPattern.singleton.case1;

public class TestPattern1 {
    public static void main(String[] args) {
        Database database = Database.getInstance("첫번째 Database");
        System.out.println("database.getName() = " + database.getName());

        Database database2 = Database.getInstance("두번째 Database");
        System.out.println("database2.getName() = " + database2.getName());
    }
}
