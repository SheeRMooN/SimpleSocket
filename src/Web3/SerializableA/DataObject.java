package Web3.SerializableA;

import java.io.*;

public class DataObject extends NonSerializable implements Serializable {
    int i = 123;
    String str = "wow";
    CustomObject customObject ;
    transient  String[] def = {"solo1", "solo2", "solo3"};

    static class Operations{
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            DataObject dataObject = new DataObject();
            dataObject.setStringNon("dsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            File file = new File("store.bin");

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

            oos.writeObject(dataObject);
            oos.flush();
            oos.close();


            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream oiStream = new ObjectInputStream(fileInputStream);
            DataObject dataSerializable = (DataObject)oiStream.readObject();
            oiStream.close();
            System.out.println(dataSerializable.stringNon);
        }
    }
}
