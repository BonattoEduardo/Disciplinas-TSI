package exercicio14;

public class MyThread implements Runnable {
    Counter c = null;

    public MyThread(Counter c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int x = 0; x < 1000000; x++) {
            c.increment();
            c.decrement();
            c.increment();
            c.decrement();
        }
    }

}
