package id2222.hw1.similaritems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Shingling {

    public Shingling(){

    }

    public Set<Integer> getShingles(String filepath, int k ){
        List<String> shingleList = new ArrayList<String>();

        String content = null;
        try {

            content = new String(Files.readAllBytes(Paths.get(filepath) ), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int counter = 0; counter < content.length() - k-1; counter++){
            shingleList.add(content.substring(counter, counter + k));
        }

        List<Integer> hashedShingles  = shingleList.stream().map(x -> x.hashCode()).sorted().collect(Collectors.toList());
        return new HashSet<>(hashedShingles);

    }




}
