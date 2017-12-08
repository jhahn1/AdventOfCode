import Day3.SpiralMemory;
import Day4.HighEntrophyPassphrases;
import Day5.TwistyTrampolines;
import Day6.MemoryReallocation;

/**
 * Created by jhahn on 12/2/17.
 */
public class Main {

    public static void main(String[] args) {

        MemoryReallocation memoryReallocation = new MemoryReallocation();

        System.out.println(memoryReallocation.getCycles(getInput()));
    }

    public static String getInput() {
        return "11\t11\t13\t7\t0\t15\t5\t5\t4\t4\t1\t1\t7\t1\t15\t11";
    }
}
