package designPattern.observer.case2;

public class TestPattern {
    public static void main(String[] args) {
        PlayController playController = new PlayController();
        Observer observer1 = new MyClassA();
        Observer observer2 = new MyClassB();

        playController.addObserver(observer1);
        playController.addObserver(observer2);

        playController.setPlay(false);

        playController.deleteObserver(observer2);

        System.out.println("-------------------------");

        playController.setPlay(true);
    }
}
