package leetcode.stack;

import java.util.Stack;

public class BasicCaclculator2_LC227 {
    public int calculate(String s) {
        //remove all the whitespace
        s = s.replaceAll("\\s+", "");
        int len = s.length();
        char[] chars = s.toCharArray();

        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        int num = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            }

            if (!Character.isDigit(c) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '+') {
                    stack.push(num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }

        }

        int res = 0;
        for (int i : stack) {
            res+= i;
        }
        return res;
    }
}
/*
Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5

 */