package string.subStringFInding;

public class Strstr {
    public  int strstr(String large, String small) {
        if (large.length() < small.length() || large == null) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        char[] largeChars = large.toCharArray();
        char[] smallChars = small.toCharArray();

        long targetMask = 0;
        long currentValue = 0;
        long base = 1;
        for (int index = 0; index < smallChars.length; index++) {
            targetMask += (smallChars[index] - 'a') * base;
            currentValue += (largeChars[index] - 'a') * base;
            base *= 26;
        }

        if (targetMask == currentValue) {
            return 0;
        }
        base /= 26;
        for (int index = 1; index <= large.length() - small.length(); index++) {//bug
            currentValue = currentValue / 26;
            currentValue += (largeChars[index + small.length() - 1] - 'a') * base;
            if (currentValue == targetMask) {
                return index;
            }
        }
        return -1;

    }
    public static void main(String args[]) {
        System.out.println(new Strstr().strstr("abcdefghijklmnopqrstuvwxyzzabcdefghijklmnopqrstu", "qrstuvwxyzzabcdefghijklmnopqrstu"));
    }
}

/*
Determine if a small string is a substring of another large string.

Return the index of the first occurrence of the small string in the large string.

Return -1 if the small string is not a substring of the large string.

Assumptions

Both large and small are not null
If small is empty string, return 0
Examples

“ab” is a substring of “bcabc”, return 2
“bcd” is not a substring of “bcabc”, return -1
"" is substring of "abc", return 0

过不了大数检验，有时间再研究取余操作
 */