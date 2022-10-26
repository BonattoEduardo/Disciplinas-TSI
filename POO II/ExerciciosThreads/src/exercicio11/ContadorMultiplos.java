package exercicio11;

public class ContadorMultiplos implements Runnable {
    private static final int INTERVAL = 5000000;
    private int number;
    private int sum = 0;
    private int count = 0;

    public ContadorMultiplos(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public int getSum() {
        return sum;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = number; i < INTERVAL; i += number) {
            sum += i;
            count++;
        }
    }
    
}
