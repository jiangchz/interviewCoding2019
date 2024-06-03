package leetcode.stack;

import java.util.Stack;

public class BasicCaclculator3_LC772 {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        return calculate(chars, 0, chars.length - 1);
    }

    private int calculate(char[] input, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        while (start <= end) {
            char c = input[start];

            //case1: we saw a left bracket, we recursively call the calculate
            if (c == '(') {
                int closingIndex = findClose(input, start, end);
                int bracketValue = calculate(input, start + 1, closingIndex - 1);
                num = bracketValue;
                start = closingIndex + 1;
                if (start >= end) {
                    saveNumber(stack, sign, num);
                    break;
                }
                //case2: we saw number
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if (start == end) {
                    saveNumber(stack, sign, num);
                    break;
                }
                start++;
                //case2: we saw a sign
            } else if (!Character.isDigit(c)) {
                saveNumber(stack, sign, num);
                sign = c;
                num = 0;
                start++;
            }
        }

        int res = 0;
        for (int i : stack) {
            res+= i;
        }
        return res;
    }

    private void saveNumber(Stack<Integer> stack, char sign, int num) {
        if (sign == '-') {
            stack.push(-num);
        } else if (sign  == '*') {
            stack.push(stack.pop()*num);
        } else if (sign == '/') {
            stack.push(stack.pop()/num);
        } else {
            stack.push(num);

        }
    }
    private int findClose(char[] input, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (input[i] == '(') {
                count++;
            } else if (input[i] == ')') {
                count--;
            }
            if (count == 0) {
                return i;
            }
        }
        return -1;
    }
}
/*
Example 1:

Input: s = "1+1"
Output: 2
Example 2:

Input: s = "6-4/2"
Output: 4
Example 3:

Input: s = "2*(5+5*2)/3+(6/2+8)"
Output: 21

 */