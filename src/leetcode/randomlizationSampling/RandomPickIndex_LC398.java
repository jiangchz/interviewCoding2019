package leetcode.randomlizationSampling;

import java.util.*;

public class RandomPickIndex_LC398 {
    Map<Integer, List<Integer>> map;
    static Random random = new Random();

    public RandomPickIndex_LC398(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<Integer>());
            list.add(i);
            map.put(nums[i], list);
        }

    }

    public int pick(int target) {
        List<Integer> indexList = map.get(target);
        return indexList.get(random.nextInt(indexList.size()));
    }

    //Simple Reservoir Sampling solution
    private int[] nums;
    private Random random2;
//    public Solution(int[] nums) {
//        this.nums = nums;
//        random2 = new Random();
//    }

    public int pick2(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != target) {
                continue;
            }

            if (random.nextInt(++count) == 0) {
                res = i;
            }
            //why it works pick the first number 1 * 1/2 * 2/3 * 3/4 * ....* (n-1/n) =  1/n
            //https://leetcode.com/problems/random-pick-index/solutions/88072/simple-reservoir-sampling-solution
        }
        return res;
    }
}
