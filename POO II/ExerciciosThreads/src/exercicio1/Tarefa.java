package exercicio1;

import java.security.SecureRandom;

public class Tarefa implements Runnable {
    private String nome;
    private SecureRandom secureRandom = new SecureRandom();

    public Tarefa(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            System.out.println("Hello thread " + this.nome);

            int menor = 1000;
            int maior = 3000;
            int sleepTime = secureRandom.nextInt(maior - menor) + menor;
            
            Thread.sleep(sleepTime);

            System.out.println("Encerrando thread " + this.nome);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
