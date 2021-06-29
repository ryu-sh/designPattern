package designPattern.observer.case3;

public class TestPattern {
    public static void main(String[] args) {
        PlayController playController = new PlayController();
        Observer observer1 = new MyClassA(playController);
        Observer observer2 = new MyClassB(playController);

        System.out.println("---- 모든 클래스 정지 -----");
        playController.setPlay(false);

        System.out.println();

        System.out.println("---- 모든 클래스 시작 -----");
        playController.setPlay(true);
    }
}
