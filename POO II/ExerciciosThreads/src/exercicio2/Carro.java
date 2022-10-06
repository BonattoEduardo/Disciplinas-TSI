package exercicio2;

import java.security.SecureRandom;
import java.time.Instant;

public class Carro implements Runnable {
    private int id;
    private Instant tempo;
    private SecureRandom random = new SecureRandom();
    
    public Carro(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Instant getTempo() {
        return tempo;
    }

    @Override
    public void run() {
        int minimo = 500;
        int maximo = 1000;

        try {
            for (int i = 0; i < 10; i++) {
                    Thread.sleep(random.nextInt(maximo - minimo) + minimo);
                    System.out.println("O carro " + id + " está na posição " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            
        tempo = Instant.now();
    }
}
