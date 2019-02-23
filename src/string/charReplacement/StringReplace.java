package string.charReplacement;

import java.util.ArrayList;

public class StringReplace {
    public static String replace(String input, String source, String target) {
        if (source.length() >= target.length()) {
            return replaceStringWithoutExtentSpace(input, source, target);
        } else {
            return replaceStringWithExtentSpace(input,  source, target);
        }
    }
    private static String replaceStringWithExtentSpace(String input, String source, String target) {
        ArrayList<Integer> matchesIndexes = findAllMatchesLastIndex(input, source);
        int totalSize = matchesIndexes.size() * (target.length() - source.length()) + input.length();
        char[] outputChars = new char[totalSize];
        copyCharArray(input, outputChars);

        int slow = totalSize - 1;
        int fast = input.length() - 1;
        int matchesIndex = matchesIndexes.size() - 1;
        while (fast >= 0) {
            if (matchesIndex >= 0 && fast == matchesIndexes.get(matchesIndex)) {
                replaceFromRightIndex(outputChars, target, slow); //bug
                slow -= target.length();
                fast -= source.length();
                matchesIndex--;
            } else {
                outputChars[slow--] = outputChars[fast--];
            }
        }
        return new String(outputChars);
    }
    private static ArrayList<Integer> findAllMatchesLastIndex(String input, String source) {
        char[] inputChars = input.toCharArray();
        int fast = 0;
        ArrayList<Integer> matches = new ArrayList<>();

        while (fast < input.length() - source.length() + 1) {
            if (matchPattern(inputChars, source, fast)) {
                matches.add(fast + source.length() - 1);
                fast += source.length();
            } else {
                fast++;
            }
        }
        return matches;
    }
    private static void copyCharArray(String input, char[] output) {
        for (int index = 0; index < input.length(); index++) {
            output[index] = input.charAt(index);
        }
    }

    private static String replaceStringWithoutExtentSpace(String input, String source, String target) {
        char[] inputChars = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < input.length()) {   //bug
            if (matchPattern(inputChars, source, fast)) {
                replaceFromLeftIndex(inputChars, target, slow); //bug write from slow
                slow += target.length();
                fast += source.length();
            } else {
                inputChars[slow++] = inputChars[fast++];
            }
        }
        return new String(inputChars, 0, slow);

    }
    private static boolean matchPattern(char[] input, String source, int startIndex) {
        for (int index = 0; index < source.length(); index++) {
            if (startIndex == input.length || input[startIndex++] != source.charAt(index)) {  //bug
                return false;
            }
        }
        return true;
    }

    private static void replaceFromLeftIndex(char[] input, String target, int startIndex) {
        for (int index = 0; index < target.length(); index++) {
            input[startIndex++] = target.charAt(index);
        }
    }

    private static void replaceFromRightIndex(char[] input, String target, int endIndex) {
        for (int index = target.length() - 1; index >= 0; index--) { //bug
            input[endIndex--] = target.charAt(index);
        }
    }

    public static void main(String args[]) {
        String test = "docomomonocomo";
        test = "omomo";
        System.out.println(replace(test, "omo", "1"));
    }
}

// fucking hard, lots of conner cases, rewrite it tomorrow.