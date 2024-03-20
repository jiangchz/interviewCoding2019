package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentIndexs = new ArrayList<>();
        dfs(result, currentIndexs, n);
        return result;
    }
    private void dfs(List<List<Integer>> result,
                     List<Integer> currentIndexes,
                     int n) {
        if (currentIndexes.size() == n) {
            result.add(new ArrayList(currentIndexes));
            return;
        }
        for (int i = 0; i < n; i++) {
            int size = currentIndexes.size();
            if (valid(currentIndexes, i)) {
                currentIndexes.add(i);
                dfs(result, currentIndexes, n);
                currentIndexes.remove(size);
            }
        }
    }
    public static void main(String args[]) {
        List<List<Integer>> results = new Nqueens().nqueens(8);
        for (List<Integer> result : results) {
            for(int num: result) {
                System.out.print(num);

            }
            System.out.println();

        }
    }
    private static boolean valid(List<Integer> currentIndex, int col) {
        for (int i = 0; i < currentIndex.size(); i++) {
            if (currentIndex.get(i) == col || Math.abs(currentIndex.get(i) - col) == currentIndex.size() - i) {
                return false;
            }
        }
        return true;
    }
}
/*
bug:
    To tell whether A(x1, y1) and B(x2, y2) in the same diagonal : if we know y2 > y1
        y2 - y1 = Math.abs(x2 - x1)
 */
