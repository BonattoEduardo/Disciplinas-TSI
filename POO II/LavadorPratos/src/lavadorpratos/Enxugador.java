package lavadorpratos;

import java.util.Random;

public class Enxugador implements Runnable {
    private final Escorredor escorredor;
    private boolean done;

    public Enxugador(Escorredor escorredor) {
        this.escorredor = escorredor;
    }

    private void enxugar() {
        synchronized (escorredor) {
            if (escorredor.vazio()) {
                try {
                    // System.out.println("Enxugador esperando prato");
                    escorredor.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
            }

            try {
                // System.out.println("Enxugador tirando o prato do escorredor");
                escorredor.tirarPrato();
                escorredor.notifyAll();
                
                Thread.sleep(calcularTempo());
                
                // System.out.println("Enxugador terminou de enxugar");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    private long calcularTempo() {
        Random random = new Random();
        // return random.nextInt(1000, 3000);
        return random.nextInt(3, 10);
    }

    public void finalizar() {
        done = true;
    }

    @Override
    public void run() {
        done = false;
        while (!done) {
            enxugar();
        }
    }
    
}
