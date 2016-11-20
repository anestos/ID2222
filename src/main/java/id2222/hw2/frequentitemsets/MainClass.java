package id2222.hw2.frequentitemsets;


import java.util.Scanner;

public class MainClass {

    public static void main(String[] args){

        System.out.println("### Homework 2: Discovery of Frequent Itemsets and Association Rules ### ");
        Scanner scanner = new Scanner(System.in);

        int s = 0;
        while(s < 1 || s > 100000) {
            System.out.println("Please select the support of items. Accepted value: [1-100000]");
            s = scanner.nextInt();
        }

        System.out.println("Computation in progress. Please wait...");
        FrequentItemsets fi = new FrequentItemsets("./src/main/resources/hw2/dataset.dat", s);

    }

}
