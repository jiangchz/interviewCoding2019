package leetcode.string;

public class StringToInteger_LC8 {
    public int myAtoi(String s) {
        char[] chars =  s.toCharArray();
        int sign = 1;
        int base = 0;
        int i = 0;

        while (i < s.length() && chars[i] == ' ') {
            i++;
        }

        if (i < s.length() && (chars[i] == '-' || chars[i] == '+')) {
            sign = chars[i] == '-' ? -1 : 1;
            i++;
        }

        while (i < s.length() && chars[i] >= '0' && chars[i] <= '9') {
            if (base >  Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && chars[i] - '0' > 7)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                }
                return Integer.MIN_VALUE;
            }
            base  = 10 * base + (chars[i++] - '0');
        }
        return base * sign;
    }
}
