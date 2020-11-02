package Web2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.108",8000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        writer.write("Hello"+ "\n");
        writer.flush();

        String messenger = reader.readLine();
        System.out.println(messenger);

        writer.close();
        reader.close();
        socket.close();
    }
}
