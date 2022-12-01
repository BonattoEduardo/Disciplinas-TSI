import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientInput implements Runnable {
    private BufferedReader userInput;
    private DataInputStream dataInput;
    private DataOutputStream dataOutput;

    public ClientInput(BufferedReader userInput, DataInputStream dataInput, DataOutputStream dataOutput) {
        this.userInput = userInput;
        this.dataInput = dataInput;
        this.dataOutput = dataOutput;
    }

    @Override
    public void run() {
        String line = "";
        
        while (!line.equals("Bora parar?")) {
            try {
              line = userInput.readLine();
              dataOutput.writeUTF(line);
            } catch (IOException i) {
              System.out.println(i);
            }
        }
    }
    
}
