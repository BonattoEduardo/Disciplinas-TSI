import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.Fork;
import classes.Philosopher;
import classes.Table;

public class PhilosophersDinner {
    private Table table;
    private List<Philosopher> philosophers;
    private List<Thread> threads;

    public PhilosophersDinner() {
        table = new Table(Arrays.asList(
            new Fork(),
            new Fork(),
            new Fork(),
            new Fork(),
            new Fork()
        ));

        philosophers = Arrays.asList(
            new Philosopher("Aristóteles", table, 1, 0),
            new Philosopher("Platão", table, 1, 2),
            new Philosopher("Sócrates", table, 2, 3),
            new Philosopher("Tales", table, 3, 4),
            new Philosopher("Heráclito", table, 4, 0)
        );

        threads = new ArrayList<>();
        philosophers.forEach(phil -> threads.add(new Thread(phil)));
    }

    public void go() {
        threads.forEach(Thread::start);
    }

    public void stop() {
        philosophers.forEach(Philosopher::done);
    }
}
