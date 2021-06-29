package designPattern.observer.case2;

import java.util.ArrayList;
import java.util.List;

public class PlayController implements Publisher{
    private List<Observer> observers = new ArrayList<>();
    private boolean play;

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObjservers() {
        for(Observer observer : observers){
            observer.update(play);
        }
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
        notifyObjservers();
    }
}
