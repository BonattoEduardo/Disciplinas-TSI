package parte2.threads;

public class ThreadA extends Thread {
    private boolean done;

    @Override
    public void run() {
        super.run();
        while (!done) {
            try {
                sleep(5000);
                System.out.println("Olá A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        this.done = true;
    }

}
