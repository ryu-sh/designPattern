package designPattern.observer.case1;

import java.util.Observable;

public class PlayController extends Observable {
    private boolean bPlay;

    public boolean isbPlay() {
        return bPlay;
    }


    // 데이터를 전달받아 플래그 값 변경
    // 새로운 데이터 들어왔음을 알림
    public void setbPlay(boolean bPlay) {
        this.bPlay = bPlay;
        setChanged();
        notifyObservers();
    }
}
