package dynamicPrograming;

public class LongestConsecutive1s {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int current = array[0];
        int max = current;
        for (int i = 1; i < array.length; i++) {
            current = array[i] == 0 ? 0 : current + 1;
            max = Math.max(current, max);
        }
        return max;
    }
}
