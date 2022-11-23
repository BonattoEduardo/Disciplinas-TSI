package parte2.threads;

public class MainThread {
    
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        
        ThreadB targetB = new ThreadB();
        Thread threadB = new Thread(targetB);
        threadB.start();

        Thread.sleep(30000);
        threadA.stopThread();
        targetB.stopThread();
    }
}
