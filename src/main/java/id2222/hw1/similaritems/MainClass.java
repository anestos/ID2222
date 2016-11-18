package id2222.hw1.similaritems;


import java.util.Set;

public class MainClass {

    public static void main(String[] args) {
        Shingling sh = new Shingling();


        Set<Integer> set1 = sh.getShingles("./src/main/resources/hw1/book1.txt", 5);
        Set<Integer> set2 = sh.getShingles("./src/main/resources/hw1/book2.txt", 5);


        MinHashing minHash = new MinHashing(100, Math.max(set1.size(), set2.size()));

        int[] signature1 = minHash.generateSignature(set1);
        int[] signature2 = minHash.generateSignature(set2);

        CompareSignatures cp = new CompareSignatures();
        System.out.println(cp.compareSignatures(signature1, signature2));

        CompareSets cs = new CompareSets();
        System.out.println(cs.findJaccardSimillarity(set1, set2));
    }

}
