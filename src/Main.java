import Day8.HeardYouLikeRegisters;
import Day9.StreamProcessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by jhahn on 12/2/17.
 */
public class Main {

    public static void main(String[] args) {

        StreamProcessing streamProcessing = new StreamProcessing();

        System.out.println(streamProcessing.getGroupCount(getInput()));
    }

    public static String getInput() {
        return "{{{}}},";
    }


}
