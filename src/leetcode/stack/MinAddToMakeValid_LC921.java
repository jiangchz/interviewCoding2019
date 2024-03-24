package leetcode.stack;

public class MinAddToMakeValid_LC921 {
    public int minAddToMakeValid(String s) {
        int leftCount = 0;
        int removed = 0;

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    removed++;
                }
            }
        }
        return removed + leftCount;
    }
}
