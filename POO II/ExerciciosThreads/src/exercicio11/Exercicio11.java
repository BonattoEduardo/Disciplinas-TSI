package exercicio11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio11 {
    
    public static void main(String[] args) {
        List<ContadorMultiplos> contadores = new ArrayList<>();

        contadores.add(new ContadorMultiplos(3));
        contadores.add(new ContadorMultiplos(4));
        contadores.add(new ContadorMultiplos(7));
        contadores.add(new ContadorMultiplos(9));
        contadores.add(new ContadorMultiplos(11));

        List<Thread> threads = contadores.stream().map(c -> new Thread(c)).collect(Collectors.toList());

        threads.forEach(Thread::start);
        
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        contadores.forEach(c -> System.out.println("Contador do " + c.getNumber() + " deu: " + c.getCount()));
        int totalSum = contadores.stream().mapToInt(ContadorMultiplos::getSum).sum();

        System.out.println("Soma total: " + totalSum);
    }
}
