package lavadorpratos;

public class App {
    private static final Escorredor escorredor = new Escorredor(10);
    private static final Lavador lavador = new Lavador(escorredor);
    private static final Enxugador enxugador = new Enxugador(escorredor);
    private static final Thread threadLavador = new Thread(lavador);
    private static final Thread threadEnxugador = new Thread(enxugador);
    
    public static void main(String[] args) {
        work();

        try {
            Thread.sleep(1000 * 60 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stop();
    }

    public static void work() {
        threadLavador.start();
        threadEnxugador.start();
    }

    public static void stop() {
        lavador.finalizar();
        enxugador.finalizar();
    }

}
