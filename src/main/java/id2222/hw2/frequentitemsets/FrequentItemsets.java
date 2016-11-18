package id2222.hw2.frequentitemsets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FrequentItemsets {

    public FrequentItemsets(String path, int s){

        List<String> content = new ArrayList<>();
        try {
             content  = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, Integer> dict = new HashMap<>();
        content.forEach(x -> Arrays.asList(x.split(" ")).forEach(y -> {dict.put(y, dict.get(y) ==null? 1 : dict.get(y) + 1);}));

        System.out.println("contentsize: " + content.size());
        System.out.println("total number of items: " + dict.size());



        List<String> dict2 = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : dict.entrySet()){

            if (entry.getValue() > s){
                dict2.add(entry.getKey());
            }
        }
        System.out.println("items appearing in more than s baskets  " + dict2.size());

        HashMap<String, Integer> dict3 = new HashMap<>();

        content.forEach(x ->{
            for (int i = 0; i < dict2 .size(); i++){
                for (int j = i + 1; j < dict2 .size(); j++){
                    List<String> rowElements = Arrays.asList(  x.split(" ")  );
                    String elem1 = dict2.get(i);
                    String elem2 = dict2.get(j);
                    if (rowElements.contains(elem1) && rowElements.contains(elem2)){
                        String both = elem1 + " " + elem2;
                        dict3.put( both, dict3.get(both) ==null? 1 : dict3.get(both) + 1);
                    }
                }
            }
        }
        );





        /// confidence level
        for (Map.Entry<String, Integer> entry : dict3.entrySet()){
            String[] elements =    entry.getKey().split(" ")  ;
            String elem1 = elements[0];
            String elem2 = elements[1];
            System.out.println("confidence of " + elem1 +  " ->" + elem2 +" = " + (entry.getValue()/ dict.get(elem1 )));
            System.out.println("confidence of " + elem2 +  " ->" + elem1 +" = " + (entry.getValue()/ dict.get(elem2 )));


        }


    }
}
