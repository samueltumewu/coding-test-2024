package BalancedBracket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class BalancedBracket {
    public static String balancedBracketFunction(String input) {
        /*
            MAIN CODE
         */
        List<Character> CLOSURE_TAGS = Arrays.asList('}', ']', ')');
        String output = "YES";

        String inputTrim = input.replaceAll(" ", "");
        LinkedList<Character> inputList = new LinkedList<>();
        for (Character value : inputTrim.toCharArray()) {
            if (!CLOSURE_TAGS.contains(value)) {
                inputList.add(value);
            } else {
                Character peekValue = inputList.peekLast();
                switch (value) {
                    case ')':
                        output = peekValue != null && peekValue == '(' ? "YES" : "NO";
                        inputList.removeLast();
                        break;
                    case '}':
                        output = peekValue != null && peekValue == '{' ? "YES" : "NO";
                        inputList.removeLast();
                        break;
                    case ']':
                        output = peekValue != null && peekValue == '[' ? "YES" : "NO";
                        inputList.removeLast();
                        break;
                }
                if (output.equalsIgnoreCase("NO")) {
                    break;
                }
            }
        }
        return output;
    }
    public static void main(String[] args) {
        String[] inputArray = new String[]{
                " { [ ( ) ] }",
                "{ [ ( ] ) }",
                " { ( ( [ ] ) [ ] ) [ ] }"
        };

        for(String input: inputArray) {
            System.out.println(balancedBracketFunction(input));
        }
    }

}
