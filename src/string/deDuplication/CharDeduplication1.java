package string.deDuplication;

public class CharDeduplication1 {
    public static String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] inputArray = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < input.length()) {
            if (slow == 0 || inputArray[fast] != inputArray[slow - 1]) {
                inputArray[slow++] = inputArray[fast];
            }
            fast++;
        }
        return new String(inputArray, 0, slow);
    }
    public static void main(String args[]) {
       System.out.println(deDup("aabbazw"));
    }
}

/*
aabbazw -> abazw
 */