package id2222.hw1.similaritems;

import java.util.HashSet;
import java.util.Set;


public class CompareSets {

    public double findJaccardSimillarity ( Set<Integer> set1, Set<Integer> set2){

        Set<Integer> union = new HashSet<> (set1);
        union.addAll(set2);


        Set<Integer> intersection = new HashSet<Integer>(set1);
        intersection.retainAll(set2);



        if (union.isEmpty()) {
            return 0;
        }

        return (double) intersection.size() / union.size();
    }

}
