import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Barbeiro implements Runnable {
    private SalaEspera salaEspera;
    private Lock lock;
    private Condition condition;
    private Cliente cliente;
    private volatile boolean done;

    public Barbeiro(SalaEspera salaEspera, Lock lock, Condition condition) {
        this.salaEspera = salaEspera;
        this.lock = lock;
        this.condition = condition;
    }

    private void cortarCabelo() {
        lock.lock();

        try {
            if (salaEspera.vazia()) {
                System.out.println("Sala de espera vazia. Esperando clientes...");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            cliente = salaEspera.retirarCliente();
            System.out.println("O barbeiro está atendendo um cliente");

            long millis = new Random().nextInt(1000, 3000);
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cliente.getConditionCliente().signal();
            System.out.println("Barbeiro terminou de atender um cliente");
        } finally {
            lock.unlock();
        }
    }
    
    public void finalizar() {
        done = true;
    }

    @Override
    public void run() {
        done = false;
        while (!done) {
            cortarCabelo();
        }
    }
}
