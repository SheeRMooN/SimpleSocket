package Web3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static boolean forever = true;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket =new ServerSocket(8080);

        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        ObjectOutputStream ooStream = new ObjectOutputStream(outputStream);
        ObjectInputStream oiStream = new ObjectInputStream(inputStream);

        while (forever){
            System.out.println(oiStream.read());
            ooStream.writeUTF("<h1> Hello ! </h1>");
            ooStream.flush();
        }

        socket.close();
    }
}
