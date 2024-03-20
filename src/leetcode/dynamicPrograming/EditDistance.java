package leetcode.dynamicPrograming;

public class EditDistance {
    public int editDistance(String one, String two) {
        int length1 = one.length();
        int length2 = two.length();

        if (length1 == 0) {
            return length2;
        } else if (length2 == 0) {
            return length1;
        }

        int[][] result = new int[length1 + 1][length2 + 1];
        initializeResultMatrix(result);

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                char char1 = one.charAt(i - 1); //bug 2
                char char2 = two.charAt(j - 1);
                if (char1 == char2) {
                    result[i][j] = result[i - 1][j -1];
                } else {
                    result[i][j] = Math.min(Math.min(result[i - 1][j -1], result[i - 1][j]),
                            result[i][j - 1]) + 1;
                }
            }
        }
        return result[length1][length2];
    }
    private static void initializeResultMatrix(int[][] result) {
        for (int i = 0; i < result.length; i++) { //bug1, current length already update to 6
            result[i][0] = i;
        }
        for (int i = 1; i < result[0].length; i++) {
            result[0][i] = i;
        }
    }
}