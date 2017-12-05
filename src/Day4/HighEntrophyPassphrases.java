package Day4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jhahn on 12/4/17.
 */
public class HighEntrophyPassphrases {

    public int getNumOfValidPassphrases(String input) {

        String[] lines = input.split(System.getProperty("line.separator"));
        int validPassPhrases = 0;
        for(String line : lines){
            ArrayList<String> elements = new ArrayList<>(Arrays.asList(line.split(" ")));
            boolean unique = elements.stream().allMatch(new HashSet<>()::add);
            if(unique) {
                validPassPhrases++;
                System.out.println("DUP BROTHA" + elements);
            }
        }

        return validPassPhrases;
    }

    public int getNumOfValidPassphrasesPart2(String input) {

        String[] lines = input.split(System.getProperty("line.separator"));
        int validPassPhrases = 0;
            for(String line : lines){
            ArrayList<String> elements = new ArrayList<>(Arrays.asList(line.split(" ")));
            ArrayList<String> duplicates = new ArrayList<>();
            elements.stream().forEach(x -> {
                char[] first = x.toCharArray();
                Arrays.sort(first);
                duplicates.add(new String(first));
            });
            boolean unique = duplicates.stream().allMatch(new HashSet<>()::add);
            if(unique) {
                validPassPhrases++;
                System.out.println("DUP BROTHA" + elements);
            }
        }

        return validPassPhrases;
    }
}
