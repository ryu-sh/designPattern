package designPattern.flyweight.case3;

public class TestPattern {
    public static void main(String[] args) {
        FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
        flyWeightFactory.getSubject("a");
        flyWeightFactory.getSubject("a");
        flyWeightFactory.getSubject("b");
        flyWeightFactory.getSubject("b");

        FlyWeightFactory flyWeightFactory2 = new FlyWeightFactory();
        flyWeightFactory2.getSubject("a");
        flyWeightFactory2.getSubject("b");
    }
}
