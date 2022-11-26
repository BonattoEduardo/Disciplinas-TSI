package lavadorpratos;

public class Lavador implements Runnable {
    private final PratosSujosFactory pratosFactory = new PratosSujosFactory();
    private final Escorredor escorredor;
    private boolean done;

    public Lavador(Escorredor escorredor) {
        this.escorredor = escorredor;
    }

    private void lavar() {
        Prato novoPrato = pratosFactory.novoPrato();

        synchronized (escorredor) {
            if (escorredor.cheio()) {
                try {
                    // System.out.println("Lavador esperando espaço no escorredor");
                    escorredor.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
            }
        
            try {
                // System.out.println("Lavador lavando novo prato");
                Thread.sleep(calcularTempo(novoPrato));
                
                // System.out.println("Lavador terminou de lavar");

                escorredor.colocarPrato(novoPrato);
                escorredor.notifyAll();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    private long calcularTempo(Prato prato) throws Exception {
        switch (prato.getNivelSugeira()) {
            case BAIXO:
                return 3;
                // return 1000;
            case MEDIO:
                return 5;
                // return 2000;
            case ENGORDURADO:
                return 10;
                // return 3000;
            default:
                throw new Exception("O nível de sugeira não foi informado!");
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
