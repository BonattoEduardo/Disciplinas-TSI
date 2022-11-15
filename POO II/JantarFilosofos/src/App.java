public class App {
    
    public static void main(String[] args) throws InterruptedException {
        PhilosophersDinner pd = new PhilosophersDinner();
        pd.go();

        Thread.sleep(1000 * 60 * 5);
        
        pd.stop();
    }
}
