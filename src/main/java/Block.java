import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp; // As number of milliseconds since 1/1/1970.

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    private String calculateHash() {
        String calculatedhash = StringUtil.applySha256(previousHash + data + timeStamp);
        return calculatedhash;
    }
}
