package Web;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        int count = 0;

        while (true){
            Socket socketClient = serverSocket.accept();
            OutputStreamWriter writer = new OutputStreamWriter(socketClient.getOutputStream());
            writer.write("<h1>Java</h1>");
            writer.flush();
            System.out.println("connect = " + count++);
            writer.close();
        }
//        serverSocket.close();
    }
}
