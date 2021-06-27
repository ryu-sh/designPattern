package designPattern.singleton.case2;

public class TestPattern2 {
    static int nNum = 0;
    public static void main(String[] args) {
        Runnable task = () -> {
            nNum++;
            Database database = Database.getInstance(nNum + "번째 Database");
            System.out.println("database : " + database.getName());
        };

        for(int i=0; i<10; i++){
            Thread t = new Thread(task);
            t.start();
        }
    }
}
