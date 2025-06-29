import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class BlockChain {

    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        if (blockchain.size() < 2)  return true;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal.");
                return false;
            }
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous Hashes not equal.");
                return false;
            }
        }
        return true;
    }
}
