package id2222.hw1.similaritems;


import java.util.Scanner;
import java.util.Set;

public class MainClass {

    public static void main(String[] args) {
        Shingling sh = new Shingling();

        System.out.println("### Homework1: Finding Similar Items: Textually Similar Documents ### ");
        Scanner scanner = new Scanner(System.in);
        int book1 = 0;
        int book2 = 0;
        int k = 0;

        System.out.println("Books for comparison:");
        System.out.println("1 - Title: Chronique de 1831 à 1862, Tome 4 (de 4) - Author: Dorothée de Dino");
        System.out.println("2 - Title: What the White Race May Learn from the Indian - Author: George Wharton James");
        System.out.println("3 - Title: The Gold-Headed Cane - Author: William Macmichael");
        System.out.println("4 - Title: Jean Cabot at Ashton - Author: Gertrude Fisher Scott");
        System.out.println("5 - Title: Sarita, the Carlist - Author: Arthur W. Marchmont");
        System.out.println("6 - Title: The Courtships of Queen Elizabeth A history of the various negotiations for her marriage - " +
                "Author: Martin Andrew Sharp Hume");
        System.out.println("7 - Title: I Will Maintain - Author: Marjorie Bowen");
        System.out.println("8 - Title: Erziehung und Unterricht der Blinden - Author: Friedrich Zech");
        System.out.println("9 - Title: The American Missionary -- Volume 32, No. 11, November, 1878 - Author: Various");
        System.out.println("10 - Title: Drawing for Printers. - Author: Ernest Knaufft ");

        while(book1 < 1 || book1 > 10) {
            System.out.println("Select the 2 book. Accepted input: [1-10]");
            book1 = scanner.nextInt();
        }

        while(book2 < 1 || book2 > 10) {
            System.out.println("Select the second book. Accepted input: [1-10]");
            book2 = scanner.nextInt();
        }

        while(k < 1 || k > 100) {
            System.out.println("Please choose the length of the shingles. [1-100]");
            k = scanner.nextInt();
        }

        System.out.println("Computation in progress. Please wait...");
        Set<Integer> set1 = sh.getShingles("./src/main/resources/hw1/book" + book1 + ".txt", k);
        Set<Integer> set2 = sh.getShingles("./src/main/resources/hw1/book" + book2 + ".txt", k);


        MinHashing minHash = new MinHashing(100, Math.max(set1.size(), set2.size()));

        int[] signature1 = minHash.generateSignature(set1);
        int[] signature2 = minHash.generateSignature(set2);

        CompareSignatures cp = new CompareSignatures();
        System.out.println("Similarity with minhash signatures: " + cp.compareSignatures(signature1, signature2));

        CompareSets cs = new CompareSets();
        System.out.println("Jaccard Similarity: " + cs.findJaccardSimillarity(set1, set2));
    }

}
