package designPattern.singleton.case4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {

    private static LogWriter singleton = new LogWriter();
    private static BufferedWriter bw;

    private LogWriter() {
        try {
            bw = new BufferedWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LogWriter getInstance(){
        return singleton;
    }

    public synchronized void log(String str){
        try {
            bw.write(str + "\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        bw.close();
    }
}
