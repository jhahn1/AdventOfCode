package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jhahn on 12/8/17.
 */
public class RecursiveCircus {

    public String getBottomProgram(String input) {

        String[] lines = input.split(System.getProperty("line.separator"));
//        ArrayList<String> discArray = new ArrayList<>();
        Set<String> stackedDiscSet = new HashSet<>();
        String baseDisc = null;

        for(String line : lines){
//            discArray.add(line.substring( 0, line.indexOf(" ")));
            if(line.contains("->")){
                String stackedDiscs = line.substring(line.indexOf("->") + 3);
                String[] stackedDiscsArray = stackedDiscs.split(", ");
                ArrayList<String> newStackedDiscs = new ArrayList<>(Arrays.asList(stackedDiscsArray));
                if(!newStackedDiscs.stream().allMatch(newStackedDiscs.get(0)::equals)){
                    System.out.println("Found it");
                }
            }
        }

//        for(String disc : discArray) {
//            if(!stackedDiscSet.contains(disc)){
//                baseDisc = disc;
//                break;
//            }
//        }
        return baseDisc;
    }
}
