package id2222.hw1.similaritems;


public class CompareSignatures {

    public double compareSignatures(int[] signature1, final int[] signature2 ){
        double counter = 0;

        for (int i = 0; i < signature1.length; i++) {
            if (signature1[i] == signature2[i]) {
                counter ++;
            }
        }

        return counter / signature1.length;
    }

}
