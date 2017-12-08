package Day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jeremyh on 12/5/17.
 */
public class TwistyTrampolines {

    public int getNumberOfSteps(String offsets) {
        String[] lines = offsets.split(System.getProperty("line.separator"));
        ArrayList<String> elements = new ArrayList<>(Arrays.asList(lines));
        List<Integer> intElements = elements.stream().map(Integer::valueOf).collect(Collectors.toList());
        int targetOffset = 0;
        int currentOffset = 0;
        int numOfSteps = 1;
        int previousoffset = 0;
        while(targetOffset>=0 && targetOffset<intElements.size()){
            if(previousoffset>2 ){
                intElements.set(currentOffset, intElements.get(currentOffset)-1);
            }
            else {
                intElements.set(currentOffset, intElements.get(currentOffset)+1);
            }
            previousoffset = intElements.get(targetOffset);
            currentOffset = targetOffset;
            targetOffset+=intElements.get(targetOffset);
            numOfSteps++;
            System.out.println("NUMBER OF STEPS" + numOfSteps);
        }
        return numOfSteps;
    }
}
