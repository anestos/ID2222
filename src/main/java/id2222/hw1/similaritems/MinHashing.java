package id2222.hw1.similaritems;

import java.util.Random;
import java.util.Set;

public class MinHashing {

    private long[][] hash_multipliers;
    private int n;
    private int size;


    public MinHashing(int n, int size){
        this.n=n;
        this.size=size;
        Random random = new Random();
        // h = (a * x) + b

        hash_multipliers = new long[n][2];
        for (int i = 0; i < n; i++) {
            hash_multipliers[i][0] = random.nextInt(size);
            hash_multipliers[i][1] = random.nextInt(size);
        }

    }

    public int[] generateSignature(Set<Integer> set1) {

        int[] signature = new int[n];

        // initialize the array with ~infinity
        for (int i = 0; i < n; i++) {
            signature[i] = Integer.MAX_VALUE;
        }

        for (int x : set1){
            for (int i = 0; i < n; i++) {
                signature[i] = Math.min( signature[i],  (int)((hash_multipliers[i][0] * (long) x + hash_multipliers[i][1]) % size));
            }
        }

        return signature;
    }
}
