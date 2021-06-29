package designPattern.observer.case3;

public interface Publisher {
    void addObserver(Observer o);
    void deleteObserver(Observer o);
    void notifyObjservers();
}
