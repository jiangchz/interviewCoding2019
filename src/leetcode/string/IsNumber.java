package leetcode.string;

public class IsNumber {
    public boolean isNumber(String s) {
        boolean hasE = false;
        boolean hasDot = false;
        boolean res = false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (Character.isDigit(current)) {
                res = true;
                continue;
            }

            if (current == 'e' || current == 'E') {
                if (hasE == true || !res) {
                    return false;
                } else {
                    hasE = true;
                    res = false;
                }
            } else if (current == '.') {
                if (hasE || hasDot) {
                    return false;
                } else {
                    hasDot = true;
                }
            } else if (current == '-' || current == '+') {
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return res;
    }
}