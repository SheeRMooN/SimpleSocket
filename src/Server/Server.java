package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        serverSocket.accept();
        System.out.println("Start");
        serverSocket.close();
    }
}
