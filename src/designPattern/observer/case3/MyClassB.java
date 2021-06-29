package designPattern.observer.case3;

public class MyClassB implements Observer {
    Publisher observable;
    private boolean bPlay;

    public MyClassB(Publisher observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(boolean play) {
        this.bPlay = play;
        myActControl();
    }

    private void myActControl() {
        if(bPlay)
            System.out.println("MyclassB 동작 시작");
        else
            System.out.println("MyclassB 동작 정지");

        observable.deleteObserver(this);
    }
}
