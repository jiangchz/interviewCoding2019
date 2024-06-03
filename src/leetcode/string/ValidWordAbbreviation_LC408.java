package leetcode.string;

public class ValidWordAbbreviation_LC408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0;
        char[] wordChar = word.toCharArray();
        char[] abbrChar = abbr.toCharArray();

        int count = 0;
        for(int i = 0; i < abbrChar.length; i++) {
            char c = abbrChar[i];
            //case 1: current char is a number
            if (Character.isDigit(c)) {
                if (count == 0 && c == '0') {
                    return false;
                }

                int val = Character.getNumericValue(abbrChar[i]);
                count = count * 10 + Character.getNumericValue(abbrChar[i]);
            } else if (Character.isLetter(c)) { //case2: current char is a letter
                if (count != 0) {
                    wordIndex += count;
                    count = 0;
                }

                if (wordIndex >= wordChar.length || abbrChar[i] != wordChar[wordIndex]) {
                    return false;
                }
                wordIndex++;
            }
        }

        return  wordIndex + count == wordChar.length;
    }
}
