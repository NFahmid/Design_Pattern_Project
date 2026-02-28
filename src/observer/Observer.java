package observer;

import strategy.Quackable;

public interface Observer {

    void update(Quackable duck);
}
