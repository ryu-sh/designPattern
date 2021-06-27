package designPattern.singleton.case4;

public class TestPattern1 {
    public static void main(String[] args) {
        LogWriter logWriter;

        logWriter = LogWriter.getInstance();
        logWriter.log("홍길동");
        logWriter.log("김철수");
    }
}
