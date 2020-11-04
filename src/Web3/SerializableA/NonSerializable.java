package Web3.SerializableA;

public class NonSerializable {
    String stringNon = "stringNon1";
    public NonSerializable() {
    }
    public NonSerializable(String stringNon){
        this.stringNon = stringNon;
    }

    public String getStringNon() {
        return stringNon;
    }

    public void setStringNon(String stringNon) {
        this.stringNon = stringNon;
    }
}
