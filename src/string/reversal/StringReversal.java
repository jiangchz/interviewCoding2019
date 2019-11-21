package string.reversal;

import static dfs.AllPermutations1.swap;

public class StringReversal {
    public static String recursiveReversal(String input) {
        int start = 0;
        int end = input.length() - 1;
        char[] inputChars = input.toCharArray();
        recursiveReversalHelper(start, end, inputChars);
        return new String(inputChars);
    }

    private static void recursiveReversalHelper(int start, int end, char[] inputChars) {
        if (start >= end) {
            return;
        }
        swap(inputChars, start, end);
        recursiveReversalHelper(++start, --end, inputChars);
    }

    public static String iterativeReversal(String input) {
        int start = 0;
        int end = input.length() - 1;
        char[] inputChars = input.toCharArray();
        while (start < end) {
            swap(inputChars, start++, end--);
        }
        return new String(inputChars);

    }

    public static void main(String args[]) {
        String test = "apple";
        System.out.println(iterativeReversal(test));
    }
}
