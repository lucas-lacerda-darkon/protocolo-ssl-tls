import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Servidor iniciado.");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado.");

        Scanner scanner = new Scanner(clientSocket.getInputStream());
        while (true) {
            String message = scanner.nextLine();
            System.out.println("Mensagem recebida: " + message);
        }
    }
}