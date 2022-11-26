import java.util.concurrent.ArrayBlockingQueue;

public class SalaEspera {
    private final ArrayBlockingQueue<Cliente> fila;

    public SalaEspera(int numCadeiras) {
        fila = new ArrayBlockingQueue<>(numCadeiras);
    }

    
    public void inserirCliente(Cliente cliente) {
        try {
            if (!cheia()) {
                fila.put(cliente);
                System.out.println("Cliente entrou na fila. Total de cadeiras ocupadas: " + fila.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Cliente retirarCliente() {
        try {
            return fila.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean cheia() {
        return fila.remainingCapacity() == 0;
    }

    public boolean vazia() {
        return fila.isEmpty();
    }

}
