package string.reversal;

import static dfs.AllPermutations1.swap;

public class ReverseWordsInASentence1 {
    public static String reverseWords(String input) {
        char[] inputChars = input.toCharArray();
        reverseEachWords(inputChars);
        recursiveReverse(inputChars, 0, input.length() - 1);

        return new String(inputChars);
    }

    private static void reverseEachWords(char[] input) {
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            while (fast < input.length && input[fast] != ' ') {
                fast++;
            }
            recursiveReverse(input, slow, fast - 1);
            slow  = ++fast;
        }
    }

    public static void recursiveReverse(char[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        swap(input, start, end);
        recursiveReverse(input, ++start, --end);
    }

    public static void main(String args[]) {
        String test = "I love Google";
        System.out.println(reverseWords(test));
    }
}

/*
“I love Google” → “Google love I”
 */


