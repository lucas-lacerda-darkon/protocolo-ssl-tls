import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Cliente extends JFrame implements KeyListener {
    private final JTextArea textArea;
    private final PrintWriter out;

    public Cliente() throws IOException {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 12345);
        System.out.println("Conectado ao servidor.");

        textArea = new JTextArea();
        textArea.addKeyListener(this);
        add(textArea);

        setMinimumSize(new Dimension(400, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        out = new PrintWriter(new OutputStreamWriter(sslSocket.getOutputStream()), true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não utilizado
    }

    @Override
    public void keyPressed(KeyEvent e) {

        String message = textArea.getText();
        out.println(message + " lentra enviada");

        textArea.setText("");

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Não utilizado
    }

    public static void main(String[] args) throws IOException {
        new Cliente();
    }
}