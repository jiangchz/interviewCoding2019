package leetcode.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        IntStream numsStream1 = Arrays.stream(nums1).limit(m);
        IntStream numsStream2 = Arrays.stream(nums2).limit(n);
        int[] res = IntStream.concat(numsStream1, numsStream2).sorted().toArray();
        System.arraycopy(res, 0, nums1, 0, res.length);
    }
}
