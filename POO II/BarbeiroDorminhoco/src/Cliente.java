import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Cliente implements Runnable {
    private SalaEspera salaEspera;
    private Lock lock;
    private Condition condition;
    private Condition conditionCliente;

    public Cliente(SalaEspera salaEspera, Lock lock, Condition condition) {
        this.salaEspera = salaEspera;
        this.lock = lock;
        this.condition = condition;
        this.conditionCliente = lock.newCondition();
    }

    private void entrarSalaEspera() {
        lock.lock();

        try {
            if (salaEspera.cheia()) {
                System.out.println("Toda as cadeiras ocupadas. Cliente foi embora.");
            } else {
                salaEspera.inserirCliente(this);
                condition.signalAll(); // Acordando o barbeiro

                try {
                    conditionCliente.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public Condition getConditionCliente() {
        return this.conditionCliente;
    }

    @Override
    public void run() {
        entrarSalaEspera();
    }
    
}
