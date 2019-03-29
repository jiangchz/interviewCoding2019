package twoPointers;


import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        String result = minWindowSubstring.minWindow(s, t);
        System.out.println(result);
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetLetterCount = countStingLetters(t);
        int[] resultIndex = linerScanForMinWindow(targetLetterCount, s);
        return resultIndex[1] == 0 ? "" : s.substring(resultIndex[0], resultIndex[1]);
    }
    private int[] linerScanForMinWindow(Map<Character, Integer> targetLetterCount,                                             String source) {
        int[] result = new int[2];
        int lettersToFind = targetLetterCount.size();
        int lettersFound = 0;
        int slow = 0;
        int fast = 0;

        while (fast < source.length()) {
            //move fast to find the window can contain target
            while (fast < source.length() && lettersFound < lettersToFind) {
                char currentChar = source.charAt(fast);
                if (targetLetterCount.containsKey(currentChar)) {
                    if (targetLetterCount.get(currentChar) == -1) {
                        lettersFound++;
                    }
                    targetLetterCount.put(currentChar, targetLetterCount.get(currentChar) + 1);
                }
                fast++;
            }
x
            //shink the window to remove unnecessary letters
            while (slow < source.length() && lettersFound == lettersToFind) {
                char currentChar = source.charAt(slow);
                if (targetLetterCount.containsKey(currentChar)) {
                    if (targetLetterCount.get(currentChar) == 0) {
                        if (result[1] == 0 || result[1] - result[0] > fast - slow) {
                            result[0] = slow;
                            result[1] = fast;
                        }
                        lettersFound--;
                    }
                    targetLetterCount.put(currentChar, targetLetterCount.get(currentChar) - 1);
                }
                slow++;
            }
        }
        return result;
    }

    private Map<Character, Integer> countStingLetters(String target) {
        Map<Character, Integer> result = new HashMap<>();
        char[] targetArray = target.toCharArray();
        for (char c: targetArray) {
            int current = result.getOrDefault(c, 0);
            result.put(c, current - 1);
        }
        return result;
    }
}