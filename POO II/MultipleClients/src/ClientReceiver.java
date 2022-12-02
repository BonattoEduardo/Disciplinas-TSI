import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceiver implements Runnable {
    private DataInputStream dataInput;

    public ClientReceiver(Socket socket) throws IOException {
        this.dataInput = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        String line = "";

        while (true) {
            try {
                line = dataInput.readUTF();
                System.out.println("Servidor: " + line);
            } catch (IOException i) {
                break;
            }
        }

        try {
            dataInput.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
