public class App {
    
    public static void main(String[] args) throws InterruptedException {
        PhilosophersDinner pd = new PhilosophersDinner();
        pd.go();

        Thread.sleep(1000 * 30);
        
        pd.stop();

        System.out.println("fim");
    }
}
