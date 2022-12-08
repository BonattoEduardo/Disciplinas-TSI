import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private int id;
    
    public ClientHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Cliente " + id + " aceito");

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String line = "";
    
            while (true) {
                try {
                    line = in.readUTF();
                    System.out.println("Cliente " + id + ": " + line);

                    if (line.equals("/clientes")) {
                        out.writeUTF("Lista de clientes: " + ServerSide.getClientMap().keySet());
                    }

                    if (line.matches("(\\/conectar)\\s*(\\d*)")) {
                        try {
                            int otherID = Integer.parseInt(line.split("\\s")[1]);

                            if (!ServerSide.getClientMap().containsKey(otherID)) {
                                throw new Exception();
                            }

                            OutputStream outputStream = ServerSide.getClientMap().get(otherID);

                            ServerSide.getConexoes().put(id, outputStream);
                            ServerSide.getConexoes().put(otherID, out);
                        } catch (Exception e) {
                            out.writeUTF("ID inválido");
                        }
                    }

                    if (ServerSide.getConexoes().containsKey(id)) {
                        OutputStream os = ServerSide.getConexoes().get(id);
                        System.out.println("aqui " + line);
                        out.writeUTF("aaa " + line);
                        os.write(line.getBytes());
                    }

                } catch (Exception i) {
                    System.out.println(i);
                    break;
                }
            }
            
            System.out.println("Fechando conexão com Cliente " + id);
            socket.close();
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public int getId() {
        return id;
    }

    public OutputStream getStream() throws IOException {
        return socket.getOutputStream();
    }
}
