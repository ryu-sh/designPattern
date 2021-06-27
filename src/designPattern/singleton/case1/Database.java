package designPattern.singleton.case1;

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

    public static Database getInstance(String name){
        if(singleton == null){
            singleton = new Database(name);
        }
        return singleton;
    }

    public String getName() {
        return name;
    }


}
