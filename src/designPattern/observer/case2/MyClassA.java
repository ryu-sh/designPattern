package designPattern.observer.case2;

public class MyClassA implements Observer{
    private boolean bPlay;

    @Override
    public void update(boolean play) {
        this.bPlay = play;
        myActControl();
    }

    private void myActControl() {
        if(bPlay)
            System.out.println("MyclassA 동작 시작");
        else
            System.out.println("MyclassA 동작 정지");
    }
}
