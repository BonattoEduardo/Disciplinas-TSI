package exercicio1;

import java.util.ArrayList;
import java.util.List;

public class ExemploThread {
    
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            threads.add(new Thread(new Tarefa("Tarefa " + i)));
        }

        threads.forEach(Thread::start);

        threads.get(0).join();

        // threads.forEach(t -> {
        //     try {
        //         t.join();
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // });

        System.out.println("Fim");
    }
}
