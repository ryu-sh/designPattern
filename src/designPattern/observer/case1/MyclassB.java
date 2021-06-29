package designPattern.observer.case1;

import java.util.Observable;
import java.util.Observer;

public class MyclassB implements Observer {

    Observable observable; // 등록될 observable
    private boolean bplay; // 실행여부

    public MyclassB(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if( o instanceof PlayController){
            PlayController myController = (PlayController) o;
            this.bplay = myController.isbPlay();
            myActControl();
        }
    }

    private void myActControl() {
        if(bplay)
            System.out.println("MyclassB 동작 시작");
        else
            System.out.println("MyclassB 동작 정지");

        observable.deleteObserver(this);
    }
}
