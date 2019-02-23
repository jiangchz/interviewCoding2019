package string.reversal;

import static string.reversal.ReverseWordsInASentence1.recursiveReverse;

public class RightShiftByNCharacters {
    public static String rightShift(String input, int n) {
        n %= input.length();
        if (n == 0 || input == null || input.length() == 0) {
            return input;
        }
        char[] inputChar = input.toCharArray();
        recursiveReverse(inputChar, 0, input.length() - n -1);
        recursiveReverse(inputChar, input.length() - n, input.length() - 1);
        recursiveReverse(inputChar, 0, input.length() - 1);
        return new String(inputChar);
    }

    public static void main(String args[]) {
        String test = "apple";
        System.out.println(rightShift(test, 2));
    }
}