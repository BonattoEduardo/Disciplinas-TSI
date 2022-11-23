package parte1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.stream.Stream;

public class Analise {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("ColecaoCotacaoLFT22.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
  
        List<Cotacao> cot = (List<Cotacao>) ois.readObject();
        Stream<Cotacao> cotStream = cot.stream();

        // 1
        cotStream.map(c -> c.getPuVendaManha()).forEach(System.out::println);

        // 2
        System.out.println("O número máximo de cotações fornecidas é " + cotStream.count());

        // 3
        double max = cotStream.map(Cotacao::getTaxaCompraManha).max((a, b) -> a.compareTo(b)).get();
        System.out.println("O valor máximo da taxa de compra é " + max);

        // 4
        cotStream
            .parallel()
            .filter(c -> Math.abs(c.getPuCompraManha() - c.getPuVendaManha()) > 6.8)
            .forEach(System.out::println);

        // 5
        cotStream.map(c -> c.getPuBaseManha() + 0.05);
  
        ois.close();
    }
}
