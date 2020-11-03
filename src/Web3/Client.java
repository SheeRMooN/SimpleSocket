package Web3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1" , 8080);

        ObjectInputStream oiStream = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream ooStream = new ObjectOutputStream(socket.getOutputStream());

        ooStream.writeObject(new Person("serializable"));

    }
}
