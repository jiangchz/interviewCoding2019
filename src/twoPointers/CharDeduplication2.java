package twoPointers;

public class CharDeduplication2 {
    public static String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] inputArray = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < input.length()) {
            if (slow == 0 || inputArray[slow - 1] != inputArray[fast]) {
                inputArray[slow++] = inputArray[fast++];
            } else if (inputArray[slow - 1] == inputArray[fast]) {   // bug 注意是else if 两种情况只能选1种
                while (fast < input.length() && inputArray[slow - 1] == inputArray[fast]) {
                    //bug 越界检查要放在前面
                    fast++;
                }
                slow--;
            }

        }
        return new String(inputArray, 0, slow);
    }
    public static void main(String args[]) {
       System.out.println(deDup("aa"));
    }
}

/*
"abbbaaccz" → "aaaccz" → "ccz" → "z"
"aabccdc" → "bccdc" → "bdc"
 */