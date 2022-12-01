import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private int id;
    private int messageCounter;
    
    public ClientHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Client accepted");

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String line = "";
    
            while (true) {
                try {
                    line = in.readUTF();
                    messageCounter++;
                    System.out.println("Cliente " + id + ": " + line);

                    out.writeUTF("Mensagem " + messageCounter + " recebida");
                } catch (EOFException i) {
                    break;
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            
            System.out.println("Closing connection");
            socket.close();
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public int getId() {
        return id;
    }

    public int getMessageCounter() {
        return messageCounter;
    }
}
