import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {

            socket = new Socket("localhost", 5000);

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            output.writeUTF("Hello from Client!");

            String message = input.readUTF();
            System.out.println("Server: " + message);

            input.close();
            output.close();
            socket.close();

        } catch (UnknownHostException e) {
            System.out.println("Server not found.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}