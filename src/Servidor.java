import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Servidor {

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
        System.out.println("Servidor iniciado.");

        SSLSocket clienteSocket = (SSLSocket) sslServerSocket.accept(); // esperando conexão
        System.out.println("Conexão recebida de " + clienteSocket.getInetAddress().getHostAddress());

        // Scanner scanner = new Scanner(clientSocket.getInputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
        while (true) {
            // String message = scanner.nextLine();
            String message = in.readLine();
            System.out.println("Mensagem recebida: " + message);
        }
        /*
         * //trata a conexão com o cliente aqui
         * BufferedReader in = new BufferedReader(new
         * InputStreamReader(clienteSocket.getInputStream()));
         * String mensagem = in.readLine();
         * System.out.println("Mensagem recebida do cliente: " + mensagem);
         */
    }
}