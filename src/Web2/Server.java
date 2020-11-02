package Web2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        boolean forever = true;

        while (forever){
            Socket socket = serverSocket.accept();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connect...");

            String request = reader.readLine();
            System.out.println(request);

            writer.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Document</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1>Easy html !</h1>\n" +
                    "</body>\n" +
                    "</html>");
            writer.flush();

            writer.close();
            reader.close();
            socket.close();
        }
        serverSocket.close();
    }
}
