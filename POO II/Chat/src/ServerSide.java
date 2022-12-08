import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSide {
  private ServerSocket server = null;

  private static Map<Integer, OutputStream> clientMap = new HashMap<>();
  private static Map<Integer, OutputStream> conexoes = new HashMap<>();

  public static void main(String[] args) throws IOException {
    new ServerSide(5000);
  }

  public ServerSide(int port) {
    try {
      server = new ServerSocket(port);
      System.out.println("Servidor iniciou");
      System.out.println("Esperando clientes...");

      ExecutorService pool = Executors.newCachedThreadPool();
      
      int threadID = 0;
      while (true) {
        ClientHandler cHandler = new ClientHandler(server.accept(), threadID++);
        clientMap.put(cHandler.getId(), cHandler.getStream());
        pool.execute(cHandler);
      }
    } catch (IOException i) {
      System.out.println(i);
    }
  }

  public static Map<Integer, OutputStream> getClientMap() {
    return clientMap;
  }

  public static Map<Integer, OutputStream> getConexoes() {
    return conexoes;
  }
}
