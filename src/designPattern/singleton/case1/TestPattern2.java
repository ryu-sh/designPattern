package designPattern.singleton.case1;

public class TestPattern2 {
    static int nNum = 0;
    public static void main(String[] args) {
        Runnable task = () -> {
            nNum++;
            Database database = Database.getInstance(nNum + "번째 Database");
            System.out.println("database : " + database.getName());
        };

        // for문은 너무 빠르기 때문에 singleton 패턴이 적용이 안됨. (getInstance if문에서 걸려버림)
        for(int i=0; i<10; i++){
            Thread t = new Thread(task);
            t.start();
        }
    }
}
