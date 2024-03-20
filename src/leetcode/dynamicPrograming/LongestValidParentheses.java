package leetcode.dynamicPrograming;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {
    //Brute Force
    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int validate = 1;
            int counter = 1;
            if (s.charAt(i) == ')') {
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                validate += s.charAt(j) == ')' ? -1 : 1;
                counter++;

                //case1: not validate
                if (validate < 0) {
                    break;
                } else if (validate == 0){
                    max = Math.max(max, counter);
                }
            }
        }
        return max;
    }

    //leetcode.stack
    public int longestValidParentheses2(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' ) {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(i - stack.peek(), max);
                }
            } else {
                stack.push(i);
            }
        }
        return max;
    }

    //dp

}
