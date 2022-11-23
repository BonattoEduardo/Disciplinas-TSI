package parte1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainA {
    
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/LFT_2022.csv"));
            Scanner scanner = new Scanner(br);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");
        }
    }
}
