package leetcode.dfs;

public class KeepDistanceForIdenticalElements {
    public int[] keepDistance(int k) {
        int[] result = new int[2 * k];
        return dfs(result, k) ? result : null;
    }

    private boolean dfs(int[] result, int length) {
        if (length == 0) {
            return true;
        }


        for (int i = 0; i < result.length - length - 1; i++) {
            if (result[i] != 0 || result[i + length + 1] != 0) {
                continue;
            }

            result[i] = length;
            result[i + length + 1] = length;
            if (dfs(result, length - 1)) {
                return true;
            }
            result[i] = 0;
            result[i + length + 1] = 0;

        }
        return false;
    }

    public static void main(String[] args) {
        KeepDistanceForIdenticalElements elements = new KeepDistanceForIdenticalElements();
        int[] result = elements.keepDistance(3);
//        for (int i : result) {
//            System.out.println(i);
//        }
    }
}