package Day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jhahn on 12/15/17.
 */
public class StreamProcessing {

    String[] array = {">", "<", "{", "}", "!"};


    public int getGroupCount(String input) {

        boolean deleteNext = false;
        char[] inputChars = input.toCharArray();

//        for(int i = 0; i < cList.size(); i++) {
//            if(String.valueOf(cList.get(i)).equals("1")){
//                deleteNext = true;
//            }
//        }

        String filterAttempt = input.chars().mapToObj(c -> (char) c).filter(i -> i>1).toString();
        return 0;
    }
}
