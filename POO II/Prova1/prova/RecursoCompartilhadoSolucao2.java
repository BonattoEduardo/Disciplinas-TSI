package parte2.concorrencia;

public class RecursoCompartilhadoSolucao2 implements Runnable {
    private int qtd;
    
	
	public RecursoCompartilhadoSolucao2(int qtd) {
		this.qtd = qtd;
	}
	
    @Override
	public void run() {
        
        synchronized (this) {
            if (qtd > 0) {
                System.out.println(Thread.currentThread().getName() + " está executando.");
                try {
                    Thread.sleep(500);
                } catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }
                qtd--;
                System.out.println(Thread.currentThread().getName() + " consumiu.");
                System.out.println("Saldo: " + qtd);
            } else {
                System.out.println(Thread.currentThread().getName() + " ficou sem recurso.");
            }
        }
	}
}
