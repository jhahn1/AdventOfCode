package Day8;

import java.util.*;

/**
 * Created by jhahn on 12/14/17.
 */
public class HeardYouLikeRegisters {

    public int getLargestValue(String input) {
        int overallMax = 0;
        LinkedHashMap<String, Integer> posValueMap = new LinkedHashMap<>();
        String[] lines = input.split(System.getProperty("line.separator"));
        for(String line : lines){
            ArrayList<String> elements = new ArrayList<>(Arrays.asList(line.split(" ")));
            posValueMap.put(elements.get(0), 0);
        }

        for(String line : lines ) {
            ArrayList<String> elements = new ArrayList<>(Arrays.asList(line.split(" ")));
            String character = elements.get(0);
            String instruction = elements.get(1);
            Integer movement = Integer.valueOf(elements.get(2));
            String secondary = elements.get(4);
            String operator = elements.get(5);
            String numb = elements.get(6);

            if(continueThisShit(posValueMap, secondary, operator, numb)){
                switch (instruction) {
                    case "inc":
                        posValueMap.replace(character, posValueMap.get(character) + movement);
                        break;
                    case "dec":
                        posValueMap.replace(character, posValueMap.get(character) - movement);
                        break;
                }
            }
            if(posValueMap.values().stream().max(Integer::compare).get() > overallMax){
                overallMax = posValueMap.values().stream().max(Integer::compare).get();
            }
        }

        return overallMax;
    }

    public boolean continueThisShit(LinkedHashMap<String, Integer> posValueMap, String secondary,
                                    String operator, String numb ){

        int secondaryInt = posValueMap.get(secondary);
        int numbInt = Integer.valueOf(numb);

        switch (operator) {
            case ">":
                return secondaryInt > numbInt ? true : false;
            case "<":
                return secondaryInt < numbInt ? true : false;
            case "<=":
                return secondaryInt <= numbInt ? true : false;
            case ">=":
                return secondaryInt >= numbInt ? true : false;
            case "==":
                return secondaryInt == numbInt ? true : false;
            case "!=":
                return secondaryInt != numbInt ? true : false;
            default: return false;
        }
    }
}
