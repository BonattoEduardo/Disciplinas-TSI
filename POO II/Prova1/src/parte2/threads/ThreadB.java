package parte2.threads;

public class ThreadB implements Runnable {
    private boolean done;

    @Override
    public void run() {
        while (!done) {
            try {
                Thread.sleep(5000);
                System.out.println("Olá B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        this.done = true;
    }
    
}
