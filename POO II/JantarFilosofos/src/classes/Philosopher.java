package classes;

public class Philosopher implements Runnable {
    private volatile boolean done;
    private int idForkLeft;
    private int idForkRight;
    private String name;
    private Table table;
    private State state;

    @Override
    public void run() {
        done = false;
        while (!done) {
            eat();
            think();
        }
    }

    public static enum State {
        THINKING,
        EATING,
        TAKING_FORKS
    }

    public Philosopher(String name, Table table, int idForkLeft, int idForkRight) {
        this.name = name;
        this.table = table;
        this.idForkLeft = idForkLeft;
        this.idForkRight = idForkRight;
    }

    public int getIdForkLeft() {
        return idForkLeft;
    }

    public int getIdForkRight() {
        return idForkRight;
    }

    public String getName() {
        return name;
    }

    public Table getTable() {
        return table;
    }

    public State getState() {
        return state;
    }

    public void eat() {
        this.state = State.TAKING_FORKS;
        System.out.println(getName() + " está pegando os garfos");
        
        Fork forkLeft = null;
        Fork forkRight = null;

        while (forkLeft == null) {
            forkLeft = table.getFork(idForkLeft);
        }
        while (forkRight == null) {
            forkRight = table.getFork(idForkRight);
        }

        this.state = State.EATING;
        System.out.println(getName() + " está comendo");
        
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            System.out.println(getName() + " comeu demais");
        }

        table.putFork(idForkLeft, forkLeft);
        table.putFork(idForkRight, forkRight);
    }

    public void think() {
        this.state = State.THINKING;
        System.out.println(getName() + " está pensando");

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            System.out.println(getName() + " pensou demais");
        }

    }

    public void done() {
        this.done = true;
    }
}
