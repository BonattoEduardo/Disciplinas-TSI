package exercicio2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Corrida {
    
    public static void main(String[] args) throws InterruptedException {
        List<Carro> carros = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            carros.add(new Carro(i));
        }

        List<Thread> threads = carros.stream().map(c -> new Thread(c)).collect(Collectors.toList());

        threads.forEach(Thread::start);

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        carros.sort(Comparator.comparing(Carro::getTempo));

        System.out.println("O carro vencedor é: " + carros.get(0).getId());
    }

}
