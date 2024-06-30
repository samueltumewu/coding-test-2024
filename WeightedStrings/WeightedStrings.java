package WeightedStrings;

import java.util.ArrayList;
import java.util.LinkedList;

public class WeightedStrings {
    public static void main(String[] args) {
        /*
            INPUT FIELDS
         */
        String input = "abbcccd";
        int[] arrayQueries = {1,3,9,8};

        /*
            MAIN CODE
         */
        final int DECREMENTOR = 96;
        input = input.toLowerCase(); //forced to convert into lower case

        LinkedList<Integer> weightResult = new LinkedList<Integer>();
        char beforeStateChar = '0';
        int beforeStateCharCounter = 0;

        for(char inputChar : input.toCharArray()) {
            if (beforeStateChar != '0' && inputChar == beforeStateChar) {
                beforeStateCharCounter++;
                weightResult.add(((int) inputChar - DECREMENTOR) * (beforeStateCharCounter>0?beforeStateCharCounter:1));
            } else {
                weightResult.add((int) inputChar - DECREMENTOR);
                beforeStateChar = inputChar;
                beforeStateCharCounter = 1;
            }
        }

        LinkedList<String> finalResult = new LinkedList<String>();
        for(int query: arrayQueries) {
            if(weightResult.contains(query)) {
                finalResult.add("YES");
            } else {
                finalResult.add("NO");
            }
        }

        System.out.println(finalResult);
    }
}
