package Day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jhahn on 12/3/17.
 */
public class CorruptionChecksum {

    public int getCheckSum(String input) {

        String[] lines = input.split(System.getProperty("line.separator"));
        Integer totalDifference = 0;
        for(String line : lines){
            ArrayList<String> elements = new ArrayList<>(Arrays.asList(line.split("\t")));
            List<Integer> intElements = elements.stream().map(Integer::valueOf).collect(Collectors.toList());
            Collections.sort(intElements);
            totalDifference += intElements.get(intElements.size() - 1) - intElements.get(0);
        }
        return totalDifference;
    }

    public int getCheckSumPart2(String input) {

        String[] lines = input.split(System.getProperty("line.separator"));
        Integer totalDifference = 0;
        for(String line : lines){
            ArrayList<String> elements = new ArrayList<>(Arrays.asList(line.split("\t")));
            List<Integer> intElements = elements.stream().map(Integer::valueOf).collect(Collectors.toList());
            outerloop:
            for(int i = 0; i<intElements.size(); i++) {
                ArrayList<Integer> newArray = new ArrayList<>(intElements);
                newArray.remove(i);
                for( int currentInt : newArray){
                    if(intElements.get(i) % currentInt == 0){
                        totalDifference+=intElements.get(i)/currentInt;
                        break outerloop;
                    }
                }
            }
        }
        return totalDifference;
    }
}
