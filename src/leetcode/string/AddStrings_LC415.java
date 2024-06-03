package leetcode.string;

public class AddStrings_LC415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        char[] numChars1 = num1.toCharArray();
        char[] numChars2 = num2.toCharArray();

        while (index1 >= 0 || index2 >= 0) {
            int value1 = index1 < 0 ? 0 : numChars1[index1] - '0';
            int value2 = index2 < 0 ? 0 : numChars2[index2] - '0';
            int sum = value1 + value2 + carry;

            sb.append(sum % 10);
            carry = sum / 10;
            index1--;
            index2--;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}

/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 *
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 */