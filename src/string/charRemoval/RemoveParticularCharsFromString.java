package string.charRemoval;

import java.util.HashSet;

public class RemoveParticularCharsFromString {
    public String remove(String input, String t) {
        if (t == null || t.length() == 0) {
            return input;
        }

        char[] inputArray = input.toCharArray();
        HashSet<Character> toRemove = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            toRemove.add(t.charAt(i));
        }
        int slow = 0;
        int fast = 0;
        while (fast < input.length()) {
            if (!toRemove.contains(inputArray[fast])) {
                inputArray[slow++] = inputArray[fast++];
            }
            fast++;

        }

        return new String(inputArray, 0, slow);

    }
}
/* 物理意义：
        fast 指针：扫描完的数组
        slow 指针：slow 指针之前的点是已经不包含particular chars

    note:
        1. char[] inputArray = input.toCharArray();
        2.  return new String(inputArray, 0, slow);


  */