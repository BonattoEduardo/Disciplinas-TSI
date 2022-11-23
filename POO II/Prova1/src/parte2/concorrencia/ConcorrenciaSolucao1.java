package parte2.concorrencia;

public class ConcorrenciaSolucao1 {
    
    public static void main(String[] args) throws InterruptedException {
        RecursoCompartilhadoSolucao1 recurso = new RecursoCompartilhadoSolucao1(2);
           	
		Thread threadA = new Thread(recurso, "Thread A");
		Thread threadB = new Thread(recurso, "Thread B");
		
		threadA.start();
		threadB.start();
		threadA.join();
		threadB.join();
		System.out.println("Programa finalizado.");
    }
}
