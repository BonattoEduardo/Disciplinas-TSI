import java.io.*;
import java.net.*;

public class ClientSide {
  private Socket socket;
  private BufferedReader input;
  private DataInputStream in;
  private DataOutputStream out;

  public ClientSide(String address, int port) {
    try {
      socket = new Socket(address, port);
      System.out.println("Connected");
      input = new BufferedReader(new InputStreamReader(System.in));
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
    } catch (UnknownHostException u) {
      System.out.println(u);
      System.exit(1);
    } catch (IOException i) {
      System.out.println(i);
      System.exit(1);
    }




    while (true) {
      try {
          line = in.readUTF();
          System.out.println("Servidor: " + line);
      } catch (EOFException i) {
          break;
      } catch (IOException i) {
          System.out.println(i);
      }
    }

    try {
      input.close();
      out.close();
      socket.close();
    } catch (IOException i) {
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    new ClientSide("127.0.0.1", 5000);
  }
}
