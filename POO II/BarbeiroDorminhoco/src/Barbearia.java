import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barbearia {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static SalaEspera salaEspera = new SalaEspera(5);
    private static Barbeiro barbeiro = new Barbeiro(salaEspera, lock, condition);
    private static Recepcionista recepcionista = new Recepcionista(salaEspera, lock, condition);
    private static Thread threadBarbeiro = new Thread(barbeiro);
    private static Thread threadRecepcionista = new Thread(recepcionista);
    
    public static void main(String[] args) throws InterruptedException {
        abrir();

        Thread.sleep(1000 * 60 * 1);

        fechar();
    }

    public static void abrir() {
        threadBarbeiro.start();
        threadRecepcionista.start();
    }

    public static void fechar() throws InterruptedException {
        // barbeiro.finalizar();
        // recepcionista.finalizar();
        threadBarbeiro.join();
        threadRecepcionista.join();
    }
}
