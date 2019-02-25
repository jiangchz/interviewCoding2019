package string.twoPointers;

public class RemoveSpaces {
    public static String remove(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        char[] inputArray = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < input.length()) {
            if (inputArray[fast] != ' ' || (slow != 0 && inputArray[slow - 1] != ' ')) { //bug2
                inputArray[slow++] = inputArray[fast];
            }
            fast++;
        }

        if (slow > 0 && inputArray[slow - 1] == ' ') { //bug1 忘记 slow  > 0  2. Slow - 1 == ' '
            slow--;
        }

        return new String(inputArray, 0, slow);

    }

    public static String removeSpaces2(String input) {
        // Write your solution here.
        if (input == null || input.length() == 0) return "";
        int slow = 0, fast = 0;
        boolean flag = false;
        char[] chars = input.toCharArray();
        while (fast < chars.length) {
            while (fast < chars.length && chars[fast] == ' ') {
                fast ++;
            }
            if (flag && fast < chars.length) {
                chars[slow++] = ' ';
            }
            while (fast < chars.length && chars[fast] != ' ') {
                chars[slow++] = chars[fast++];
            }
            flag = true;
        }

        return new String(chars, 0, slow);
    }
    public static void main (String args[]) {
        String test = " I Love  Yahoo ";
        System.out.println(remove(test));
        System.out.println(removeSpaces2(test));

    }
}

/*
    //todo 重新写一下这个题， 注意循环控制条件和post-processing


  */