package parte1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Analise {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("ColecaoCotacaoLFT22.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Cotacao> cot = (ArrayList<Cotacao>) ois.readObject();
        ois.close();

        // 1
        cot.stream().map(Cotacao::getPuVendaManha).forEach(System.out::println);

        // 2
        System.out.println("O número máximo de cotações fornecidas é " + cot.stream().count());

        // 3
        double max = cot.stream().map(Cotacao::getTaxaCompraManha).max((a, b) -> a.compareTo(b)).get();
        System.out.println("O valor máximo da taxa de compra é " + max);

        // 4
        cot.stream()
            .parallel()
            .filter(c -> Math.abs(c.getPuCompraManha() - c.getPuVendaManha()) > 6.8)
            .forEach(System.out::println);

        // 5
        cot.stream().map(c -> c.getPuBaseManha() + 0.05).forEach(System.out::println);
  
    }
}
