package exercicio15;

public class MyTask implements Runnable {
    private static int id = 0;
    private String name;

    public MyTask() {
        this.name = "MyTask_" + id++;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running " + name);
        this.process();
        System.out.println(name + " End.");
    }

    private void process() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
