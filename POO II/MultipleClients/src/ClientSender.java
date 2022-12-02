import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSender implements Runnable {
    private BufferedReader userInput;
    private DataOutputStream dataOutput;

    public ClientSender(Socket socket) throws IOException {
      this.userInput = new BufferedReader(new InputStreamReader(System.in));
      this.dataOutput = new DataOutputStream(socket.getOutputStream());
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

        try {
          userInput.close();
          dataOutput.close();
        } catch (IOException e) {
          System.out.println(e);
        }
    }
    
}
