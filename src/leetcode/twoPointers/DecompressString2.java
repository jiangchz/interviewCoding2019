package leetcode.twoPointers;

public class DecompressString2 {
    public static String decompress(String inputString) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char[] input = inputString.toCharArray();
        while (index + 1 < input.length) {
            char currentChar = input[index];
            int times = input[index + 1] - '0';
            while (times > 0) {
                sb.append(currentChar);
                times--;
            }
            index += 2;
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        System.out.println(decompress("x2y0i0z3"));
    }
}


/*
Given a leetcode.string in compressed form, decompress it to the original leetcode.string.
The adjacent repeated characters in the original leetcode.string are compressed
to have the character followed by the number of repeated occurrences.

Assumptions

The leetcode.string is not null

The characters used in the original leetcode.string are guaranteed to be ‘a’ - ‘z’

There are no adjacent repeated characters with length > 9

Examples

“a1c0b2c4” → “abbcccc”


 */