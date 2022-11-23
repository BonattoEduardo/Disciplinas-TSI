package parte2.concorrencia;

public class Concorrencia {
	public static void main(String args[]) throws Exception {
		RecursoCompartilhado recurso = new RecursoCompartilhado(1);
           	
		Thread threadA = new Thread(recurso, "Thread A");
		Thread threadB = new Thread(recurso, "Thread B");
		
		threadA.start();
		threadB.start();
		threadA.join();
		threadB.join();
		System.out.println("Programa finalizado.");
	}
}