package designPattern.observer.case1;

public class TestPattern {
    public static void main(String[] args) {
        PlayController controller = new PlayController();

        MyclassA myclassA = new MyclassA(controller);
        MyclassB myclassB = new MyclassB(controller);

        System.out.println("---- 모든 클래스 정지 -----");
        controller.setbPlay(false);

        System.out.println();

        System.out.println("---- 모든 클래스 시작 -----");
        controller.setbPlay(true);
    }
}
