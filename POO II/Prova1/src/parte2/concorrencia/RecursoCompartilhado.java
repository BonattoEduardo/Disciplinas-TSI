package parte2.concorrencia;

class RecursoCompartilhado implements Runnable {
	private int qtd;
	
	public RecursoCompartilhado(int qtd) {
		this.qtd = qtd;
	}
	
	public void run() {
		if (qtd > 0) {
			System.out.println(Thread.currentThread().getName() + " está executando.");
			try {
				Thread.sleep(500);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			qtd--;
			System.out.println(Thread.currentThread().getName() + " consumiu.");
			System.out.println("Saldo: " + qtd);
		}
		else {
			System.out.println(Thread.currentThread().getName() + " ficou sem recurso.");
		}
	}

}