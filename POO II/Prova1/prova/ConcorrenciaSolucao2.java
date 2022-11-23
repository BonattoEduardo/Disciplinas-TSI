package parte2.concorrencia;

public class ConcorrenciaSolucao2 {
    
    public static void main(String[] args) throws InterruptedException {
        RecursoCompartilhadoSolucao2 recurso = new RecursoCompartilhadoSolucao2(2);
           	
		Thread threadA = new Thread(recurso, "Thread A");
		Thread threadB = new Thread(recurso, "Thread B");
		
		threadA.start();
		threadB.start();
		threadA.join();
		threadB.join();
		System.out.println("Programa finalizado.");
    }
}
