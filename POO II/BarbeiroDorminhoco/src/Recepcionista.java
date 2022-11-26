import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Recepcionista implements Runnable {
    private final Random random = new Random();
    private SalaEspera salaEspera;
    private Lock lock;
    private Condition condition;
    private boolean done;

    public Recepcionista(SalaEspera salaEspera, Lock lock, Condition condition) {
        this.salaEspera = salaEspera;
        this.lock = lock;
        this.condition = condition;
    }

    private void receberCliente() {
        long millis = random.nextInt(1000, 2000);

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Cliente cliente = new Cliente(salaEspera, lock, condition);
        Thread threadCliente = new Thread(cliente);
        threadCliente.start();
    }

    public void finalizar() {
        done = true;
    }

    @Override
    public void run() {
        done = false;
        while (!done) {
            receberCliente();
        }
    }
    
}
