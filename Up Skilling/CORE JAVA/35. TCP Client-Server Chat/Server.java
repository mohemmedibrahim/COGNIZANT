import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {

            serverSocket = new ServerSocket(5000);
            System.out.println("Server is waiting for client...");

            socket = serverSocket.accept();
            System.out.println("Client connected.");

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Client: " + message);

            output.writeUTF("Hello from Server!");

            input.close();
            output.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}