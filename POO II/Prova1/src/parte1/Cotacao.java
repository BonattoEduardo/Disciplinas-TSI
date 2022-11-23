package parte1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cotacao implements Serializable {
    private static String vencimento;
    private String dia;
    private double taxaCompraManha;
    private double taxaVenda;
    private double puCompraManha;
    private double puVendaManha;
    private double puBaseManha;

    public Cotacao(String dia, String taxaCompraManha, String taxaVenda, String puCompraManha, String puVendaManha,
            String puBaseManha) {
        this.dia = dia;
        this.taxaCompraManha = Double.parseDouble(taxaCompraManha.replaceAll("[^0-9.]", ""));
        this.taxaVenda = Double.parseDouble(taxaVenda.replaceAll("[^0-9.]", ""));
        this.puCompraManha = Double.parseDouble(puCompraManha.replaceAll("[^0-9.]", ""));
        this.puVendaManha = Double.parseDouble(puVendaManha.replaceAll("[^0-9.]", ""));
        this.puBaseManha = Double.parseDouble(puBaseManha.replaceAll("[^0-9.]", ""));
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/LFT_2022.csv"));
            Scanner scanner = new Scanner(br);

            Cotacao.vencimento = scanner.nextLine().split(",")[1];
            scanner.nextLine(); // Pulando o cabeçalho

            List<Cotacao> cotacoes = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String[] itens = scanner.nextLine().split(",");
                Cotacao cot = new Cotacao(itens[0], itens[1], itens[2], itens[3], itens[4], itens[5]);
                cotacoes.add(cot);
            }

            scanner.close();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ColecaoCotacaoLFT22.txt"));

            oos.writeObject(cotacoes);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado");
        }
    }

    @Override
    public String toString() {
        return "Cotacao [dia=" + dia + ", taxaCompraManha=" + taxaCompraManha + ", taxaVenda=" + taxaVenda
                + ", puCompraManha=" + puCompraManha + ", puVendaManha=" + puVendaManha + ", puBaseManha=" + puBaseManha
                + "]";
    }

    public static String getVencimento() {
        return vencimento;
    }

    public String getDia() {
        return dia;
    }

    public double getTaxaCompraManha() {
        return taxaCompraManha;
    }

    public double getTaxaVenda() {
        return taxaVenda;
    }

    public double getPuCompraManha() {
        return puCompraManha;
    }

    public double getPuVendaManha() {
        return puVendaManha;
    }

    public double getPuBaseManha() {
        return puBaseManha;
    }

    
}
