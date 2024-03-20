package leetcode.dynamicPrograming;

public class WoodCut1 {
    public static int minCost(int[] cuts, int length) {
        int[] allCutIndex = createTotalCutArray(cuts, length);
        return searchMinCost(allCutIndex);
    }

    private static int searchMinCost(int[] cuts) {
        int[][] minCost = new int[cuts.length][cuts.length];
        for (int len = 1; len < cuts.length; len++) {
            for (int firstIndex = 0; firstIndex + len < cuts.length; firstIndex++) {
                int secondIndex = firstIndex + len;
                if (len <= 1) {
                    continue;
                }
                minCost[firstIndex][secondIndex] = Integer.MAX_VALUE;//关键：取最小的时候，如果没有初始化的话，那每次都会取到0
                for (int midIndex = firstIndex + 1; midIndex < secondIndex; midIndex++) {
                    minCost[firstIndex][secondIndex] = Math.min(minCost[firstIndex][midIndex] + minCost[midIndex][secondIndex],
                            minCost[firstIndex][secondIndex]);
                }
                minCost[firstIndex][secondIndex] += (cuts[secondIndex] - cuts[firstIndex]);
            }
        }
        return minCost[0][cuts.length - 1];
    }

    private static int[] createTotalCutArray(int[] cuts, int totalLen) {
        int len = cuts.length;
        int[] result = new int[len + 2];
        for (int i = 0; i < len; i++) {
            result[i + 1] = cuts[i];
        }
        result[len + 1] = totalLen;
        return result;
    }
    public static void main(String[] args) {
        int[] test = new int[] {2,4,7};
        System.out.println(minCost(test, 10));
    }
}
