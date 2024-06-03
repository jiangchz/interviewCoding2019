package leetcode.string;

public class MaximumSwap_LC670 {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int len = chars.length;
        //store the indexes of the digits which are greater than the current digit that we are looking at.
        int[] maxPosList = new int[len];

        //initialize max position
        int maxPos = len-1;
        maxPosList[len-1] = maxPos;

        //right to left to update maxPositions
        for (int i = len-2; i >= 0; i--){
            if (chars[i] > chars[maxPosList[i+1]]) {
                maxPos = i;
                maxPosList[i] = maxPos;
            }
            maxPosList[i] = maxPos;
        }



        // left to right to find the first mismatch position
        for (int i = 0; i < len ; i++){
            maxPos = maxPosList[i];
            if (chars[i] != chars[maxPos]){ // mismatch
                char tmp = chars[maxPos] ;
                chars[maxPos] = chars[i];
                chars[i] = tmp;
                break;
            }
        }

        return Integer.parseInt(String.valueOf(chars));
    }

}

/**
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 *
 * Return the maximum valued number you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 *
 * Input: num = 9973
 * Output: 9973
 * Explanation: No swap.
 */