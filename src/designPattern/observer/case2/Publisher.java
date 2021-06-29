package designPattern.observer.case2;

public interface Publisher {
    void addObserver(Observer o);
    void deleteObserver(Observer o);
    void notifyObjservers();
}
