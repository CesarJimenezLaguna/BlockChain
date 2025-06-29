import com.google.gson.GsonBuilder;

import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {

        BlockChain.blockchain.add(new Block("Hi im the first block", "0"));
        BlockChain.blockchain.add(new Block("Yo im the second block", BlockChain.blockchain.getLast().getHash()));
        BlockChain.blockchain.add(new Block("Hey im the third block", BlockChain.blockchain.getLast().getHash()));

        IntStream.range(0, BlockChain.blockchain.size())
                .forEach(i -> {
                    System.out.println("Trying to Mine block " + i + "...");
                    BlockChain.blockchain.get(i).mineBlock(BlockChain.difficulty);
                });

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(BlockChain.blockchain);
        System.out.println("\nBlockChain:\n" + blockchainJson);
    }
}
