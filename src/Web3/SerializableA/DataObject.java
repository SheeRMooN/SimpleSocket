package Web3.SerializableA;

import java.io.*;

public class DataObject extends NonSerializable implements Serializable {
    int i = 123;
    String str = "wow";
    CustomObject customObject ;
    transient  String[] def = {"solo1", "solo2", "solo3"};

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); //прочитать данные класса чтобы не потерять поля. при сериализации
        out.writeObject(getStringNon());
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); //загрузить данные класса int i = 123,String str = "wow",transient  String[] def ...
        setStringNon( (String)in.readObject());
    }

}
 class Operations{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataObject dataObject = new DataObject();
        dataObject.setStringNon("dsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(dataObject.getStringNon());
        File file = new File("store.bin");

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

        oos.writeObject(dataObject);

        oos.flush();
        oos.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream oiStream = new ObjectInputStream(fileInputStream);
        DataObject dataSerializable = (DataObject)oiStream.readObject();

        System.out.println(dataSerializable.getStringNon());
        oiStream.close();
    }
}