package lavadorpratos;

public class Lavador implements Runnable {
    private final PratosSujosFactory pratosFactory = new PratosSujosFactory();
    private final Escorredor escorredor;
    private boolean done;

    public Lavador(Escorredor escorredor) {
        this.escorredor = escorredor;
    }

    private void lavar() {
        synchronized (escorredor) {
            while (escorredor.cheio()) {
                try {
                    escorredor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            pratosFactory.novoPrato();
        }
    }

    public void finalizar() {
        done = true;
    }

    @Override
    public void run() {
        done = false;
        while (!done) {
            lavar();
        }
    }
    
}
