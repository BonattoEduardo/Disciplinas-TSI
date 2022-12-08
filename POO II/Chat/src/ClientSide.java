import java.io.*;
import java.net.*;

public class ClientSide {
  private Socket socket;

  public ClientSide(String address, int port) {
    try {
      socket = new Socket(address, port);
      System.out.println("Conectado");
      
      Thread senderThread = new Thread(new ClientSender(socket));
      Thread receiverThread = new Thread(new ClientReceiver(socket));

      senderThread.start();
      receiverThread.start();

      senderThread.join();
      receiverThread.join();

      socket.close();
    } catch (UnknownHostException u) {
      System.out.println(u);
    } catch (IOException i) {
      System.out.println(i);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    new ClientSide("127.0.0.1", 5000);
  }
}
