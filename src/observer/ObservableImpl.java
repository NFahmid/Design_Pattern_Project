package observer;

import strategy.Quackable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObservableImpl implements Observable {

    private final List<Observer> observers = new ArrayList<>();
    private final Quackable duck;

    public ObservableImpl(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer observer = iterator.next();
            observer.update(duck);
        }
    }
}
