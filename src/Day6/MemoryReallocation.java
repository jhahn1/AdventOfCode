package Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by jeremyh on 12/6/17.
 */
public class MemoryReallocation {

    public int getCycles(String input){
        ArrayList<String> elements = new ArrayList<>(Arrays.asList(input.split("\t")));
        ArrayList<Integer> intElements = new ArrayList<>(elements.stream().map(Integer::valueOf).collect(Collectors.toList()));

        int cycle = 0;
        boolean foundIt = false;
        ArrayList<ArrayList<Integer>> dupCheckList = new ArrayList<>();
        while(!foundIt){
            int max = Collections.max(intElements);
//            int index = intElements.indexOf(max);
//            intElements.set(intElements.indexOf(max), 0);
            boolean seenMax = false;
            int remainder = max%3;
            int divisor = max/3;


//            for(int i = index+1; i<max; i++){
//                intElements.set(intElements.get(i), intElements.get(i)+1);
//            }

            for(int i = 0; i<intElements.size(); i++) {
                if(intElements.get(i) == max && !seenMax) {
                    intElements.set(i, remainder);
                    seenMax = true;
                } else {
                    intElements.set(i, intElements.get(i) + divisor);
                }
            }

            cycle++;
            if(dupCheckList.contains(intElements)){
                foundIt = true;
            } else {
                dupCheckList.add(new ArrayList<>(intElements));
            }
            System.out.println("CYCLE = " + cycle);
        }
//
//            int maxElement = sortedArray.get(sortedArray.size()-1);
//            int remainder = maxElement%3;
//            int divisor = maxElement/3;
//            boolean seenMax = false;
//
//            for(int i = 0; i<intElements.size(); i++) {
//                if(intElements.get(i) == maxElement && !seenMax) {
//                    intElements.set(i, remainder);
//                    seenMax = true;
//                } else {
//                    intElements.set(i, intElements.get(i) + divisor);
//                }
//            }
//            cycle++;
//            if(dupCheckList.contains(intElements)){
//                foundIt = true;
//            } else {
//                dupCheckList.add(new ArrayList<>(intElements));
//            }
//            System.out.println("CYCLE = " + cycle);
//        }
        return cycle;
    }
}
