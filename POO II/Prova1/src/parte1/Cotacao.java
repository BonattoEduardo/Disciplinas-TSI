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
        this.taxaCompraManha = parseDouble(taxaCompraManha);
        this.taxaVenda = parseDouble(taxaVenda);
        this.puCompraManha = parseDouble(puCompraManha);
        this.puVendaManha = parseDouble(puVendaManha);
        this.puBaseManha = parseDouble(puBaseManha);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/LFT_2022.tsv"));
            Scanner scanner = new Scanner(br);

            Cotacao.vencimento = scanner.nextLine().split("\t")[1];
            scanner.nextLine(); // Pulando o cabeçalho

            List<Cotacao> cotacoes = new ArrayList<>();

            while (scanner.hasNextLine()) {
                
                String[] itens = scanner.nextLine().split("\t");
                Cotacao cot = new Cotacao(itens[0], itens[1], itens[2], itens[3], itens[4], itens[5]);
                cotacoes.add(cot);
            }

            scanner.close();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ColecaoCotacaoLFT22.txt"));

            oos.writeObject(cotacoes);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
        }
    }

    private double parseDouble(String str) {
        str = str.replaceAll("\\.", "")
                 .replaceAll(",", ".")
                 .replaceAll("[^0-9.,]", "");
        return Double.parseDouble(str);
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

    @Override
    public String toString() {
        return "Cotacao [dia=" + dia + ", taxaCompraManha=" + taxaCompraManha + ", taxaVenda=" + taxaVenda
                + ", puCompraManha=" + puCompraManha + ", puVendaManha=" + puVendaManha + ", puBaseManha=" + puBaseManha
                + "]";
    }
}
