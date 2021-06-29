package designPattern.observer.case3;

import java.util.ArrayList;
import java.util.List;

public class PlayController implements Publisher {
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
//        observers에서 observser 삭제시, ConcurrentModificationException 이 발생한다.
//        for(Observer observer : observers){
//            observer.update(play);
//        }
        for(int i=0; i<observers.size(); i++){
            observers.get(i).update(play);
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
