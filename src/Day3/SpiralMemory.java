package Day3;

import com.sun.tools.javac.util.Pair;

import java.util.*;

/**
 * Created by jhahn on 12/3/17.
 */
public class SpiralMemory {

    LinkedHashMap<Pair<Integer, Integer>, Integer> posValueMap = new LinkedHashMap<>();

    public int getManhattanDistance(Integer input) {

        String direction = "EAST";
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        x.add(0);
        y.add(0);

        for(int i = 1; i < input; i++){
            System.out.println("LOOP NUMBER " + i);
            ArrayList<Integer> xSorted = new ArrayList<>(x);
            Collections.sort(xSorted);
            ArrayList<Integer> ySorted = new ArrayList<>(y);
            Collections.sort(ySorted);

            switch(direction){
                case "NORTH":
                    x.add(x.get(i-1));
                    y.add(y.get(i-1) + 1);
                    if(y.get(i) > ySorted.get(ySorted.size()-1))
                        direction = "WEST";
                    break;
                case "SOUTH":
                    x.add(x.get(i-1));
                    y.add(y.get(i-1) - 1);
                    if(y.get(i) < ySorted.get(0))
                        direction = "EAST";
                    break;
                case "EAST":
                    x.add(x.get(i-1) + 1);
                    y.add(y.get(i-1));
                    if(x.get(i) > xSorted.get(xSorted.size()-1))
                        direction = "NORTH";
                    break;
                case "WEST":
                    x.add(x.get(i-1) - 1);
                    y.add(y.get(i-1));
                    if(x.get(i) < xSorted.get(0))
                        direction = "SOUTH";
                    break;
            }
        }

        return Math.abs(x.get(input-1)) + Math.abs(y.get(input -1));
    }

    public int getManhattanDistancePart2(int input) {

        String direction = "EAST";
        List<Pair<Integer, Integer>> xy = new ArrayList<>();
        posValueMap.put(new Pair<>(0,0), 1);
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        x.add(0);
        y.add(0);
        int sum = 0;

        outerLoop:
        for(int i = 1; i < input; i++){
            System.out.println("LOOP NUMBER " + i);
            Pair<Integer, Integer> currentPair;
            ArrayList<Integer> xSorted = new ArrayList<>(x);
            Collections.sort(xSorted);
            ArrayList<Integer> ySorted = new ArrayList<>(y);
            Collections.sort(ySorted);

            switch(direction){
                case "NORTH":
                    x.add(x.get(i-1));
                    y.add(y.get(i-1) + 1);
                    currentPair = new Pair<>(x.get(i-1),y.get(i-1) + 1);
                    sum = getSquareSum(currentPair);
                    if(sum>input)
                        break outerLoop;
                    posValueMap.put(currentPair, sum);
                    if(y.get(i) > ySorted.get(ySorted.size()-1))
                        direction = "WEST";
                    break;
                case "SOUTH":
                    x.add(x.get(i-1));
                    y.add(y.get(i-1) - 1);
                    currentPair = new Pair<>(x.get(i-1),y.get(i-1) - 1);
                    sum = getSquareSum(currentPair);
                    if(sum>input)
                        break outerLoop;
                    posValueMap.put(currentPair, sum);
                    if(y.get(i) < ySorted.get(0))
                        direction = "EAST";
                    break;
                case "EAST":
                    x.add(x.get(i-1) + 1);
                    y.add(y.get(i-1));
                    currentPair = new Pair<>(x.get(i-1) + 1,y.get(i-1));
                    sum = getSquareSum(currentPair);
                    if(sum>input)
                        break outerLoop;
                    posValueMap.put(currentPair, sum);
                    if(x.get(i) > xSorted.get(xSorted.size()-1))
                        direction = "NORTH";
                    break;
                case "WEST":
                    x.add(x.get(i-1) - 1);
                    y.add(y.get(i-1));
                    currentPair = new Pair<>(x.get(i-1) - 1,y.get(i-1));
                    sum = getSquareSum(currentPair);
                    if(sum>input)
                        break outerLoop;
                    posValueMap.put(currentPair, sum);
                    if(x.get(i) < xSorted.get(0))
                        direction = "SOUTH";
                    break;
            }
        }
        return sum;
    }

    public int getSquareSum(Pair<Integer, Integer> currentPair){
        int squareSum = 0;
        if(posValueMap.containsKey(Pair.of(currentPair.fst+1,currentPair.snd)))
            squareSum += posValueMap.get(Pair.of(currentPair.fst+1,currentPair.snd));
        if(posValueMap.containsKey(Pair.of(currentPair.fst,currentPair.snd+1)))
            squareSum += posValueMap.get(Pair.of(currentPair.fst,currentPair.snd+1));
        if(posValueMap.containsKey(Pair.of(currentPair.fst,currentPair.snd-1)))
            squareSum += posValueMap.get(Pair.of(currentPair.fst,currentPair.snd-1));
        if(posValueMap.containsKey(Pair.of(currentPair.fst-1,currentPair.snd)))
            squareSum += posValueMap.get(Pair.of(currentPair.fst-1,currentPair.snd));
        if(posValueMap.containsKey(Pair.of(currentPair.fst+1,currentPair.snd+1)))
            squareSum += posValueMap.get(Pair.of(currentPair.fst+1,currentPair.snd+1));
        if(posValueMap.containsKey(Pair.of(currentPair.fst-1,currentPair.snd-1)))
            squareSum += posValueMap.get(Pair.of(currentPair.fst-1,currentPair.snd-1));
        if(posValueMap.containsKey(Pair.of(currentPair.fst-1,currentPair.snd+1)))
            squareSum += posValueMap.get(Pair.of(currentPair.fst-1,currentPair.snd+1));
        if(posValueMap.containsKey(Pair.of(currentPair.fst+1,currentPair.snd-1)))
            squareSum += posValueMap.get(Pair.of(currentPair.fst+1,currentPair.snd-1));
        return squareSum;
    }
}
