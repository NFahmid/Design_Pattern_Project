import adapter.Goose;
import adapter.GooseAdapter;
import composite.Flock;
import decorator.QuackCounter;
import factory.AbstractDuckFactory;
import factory.CountingDuckFactory;
import observer.Quackologist;
import strategy.Quackable;

public class Main {

    public static void main(String[] args) {
        // Abstract Factory pattern
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        // Strategy pattern
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable rubberDuck = duckFactory.createRubberDuck();

        // Adapter pattern
        Quackable gooseDuck = new GooseAdapter(new Goose());

        // Composite pattern
        Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redheadDuck);
        flock.add(rubberDuck);
        flock.add(gooseDuck);

        // Observer pattern
        Quackologist quackologist = new Quackologist();
        flock.registerObserver(quackologist);

        // Simulate pattern
        System.out.println("--- Duck Simulator ---");
        flock.quack();

        // Decorator pattern
        System.out.println("---");
        System.out.println("Total quacks: " + QuackCounter.getQuacks());
    }
}
