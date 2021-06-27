package designPattern.singleton.case2;

public class Database {
    private static Database singleton;
    private String name;

    private Database(String name) {
        try {
            Thread.sleep(100);
            this.name = name;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //synchronized 비용이 비쌈. 병목현상이 일어남.
    public synchronized static Database getInstance(String name){
        if(singleton == null){
            singleton = new Database(name);
        }
        return singleton;
    }

    public String getName() {
        return name;
    }


}
