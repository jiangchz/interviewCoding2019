package leetcode.dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllValidPermutationsOfParentheses2 {

    //used to store the chars and mapping relationship by index
    private static final char[] PS = new char[] {'(', ')', '<','>','{','}'};//PS is a constant, need to capitalize

    public static List<String> validParentheses(int l, int m, int n) {
        List<String> results = new ArrayList<>();
        StringBuilder currentChars = new StringBuilder();
        int size = (m + n + l) * 2;
        int[] remains = new int[] {l, l, m, m, n, n};
        Deque<Character> stack = new LinkedList<>();
        dfs(results, currentChars, size, remains,stack );
        return results;
    }

    private static void dfs(List<String> results,
                            StringBuilder currentChars,
                            int size,
                            int[] remains,
                            Deque<Character> stack) {
      if (currentChars.length() == size) {
          results.add(currentChars.toString());
          return;
      }

      for (int i = 0; i < remains.length; i++) {
          if (i % 2 == 0) {
              if (remains[i] > 0) {
                  currentChars.append(PS[i]);
                  stack.push(PS[i]);
                  remains[i]--;
                  dfs(results, currentChars, size, remains, stack);

                  remains[i]++;
                  currentChars.deleteCharAt(currentChars.length() - 1);
                  stack.pop();
              }
          } else {
              if (!stack.isEmpty() && PS[i - 1] == stack.peek()) {
                  stack.pop();
                  remains[i]--;
                  currentChars.append(PS[i]);
                  dfs(results, currentChars, size, remains, stack);

                  remains[i]++;
                  currentChars.deleteCharAt(currentChars.length() - 1);
                  stack.push(PS[i - 1]);
              }
          }
      }
    }

    public static void main(String args[]) {
        List<String> results = validParentheses(2,2,2);
        for (String result : results) {
            System.out.println(result);
        }
    }

    // initial thinking for reference --> can be replaced by a one dimensional leetcode.array
    @Deprecated
    private class RemainParentheses {
        public int l_left;
        public int l_right;
        public int m_left;
        public int m_right;
        public int n_left;
        public int n_right;

        public RemainParentheses(int l, int m, int n) {
            this.l_left = l;
            this.l_right = l;
            this.m_left = m;
            this.m_right = m;
            this.n_left = n;
            this.n_right = n;
        }

        public int getSize(char c) {
            if (c == '(') {
                return l_left;
            } else if (c == '[') {
                return m_left;
            } else if (c == '{') {
                return n_left;
            } else {
                return 0;
            }
        }
    }

    //can be replaced by a one dimensional leetcode.array and the mapping information can reply on the index
    @Deprecated
    private static char getReverse(char c) {
        if (c == '(') {
            return ')';
        } else if (c == '{') {
            return '}';
        } else if (c == '[') {
            return ']';
        } else {
            return ' ';
        }
    }

}

/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]


 */