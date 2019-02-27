package dynamicPrograming;

public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        int[] maxProducts = new int[length + 1];
        maxProducts[1] = 0;
        for (int i = 2; i <= length; i++) {
            int currentMax = 0;
            for (int j = 1; j < i; j++) {
                currentMax = Math.max(currentMax, Math.max(maxProducts[j], j) * (i - j));
            }
            maxProducts[i] = currentMax;
        }
        return maxProducts[length];
    }
}

/*
Given a rope with positive integer-length n,
how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1],
in order to get the maximal product of p[0]*p[1]* ... *p[m-1]?
m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.

Assumptions

n >= 2
Examples

n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).

M[i]: the largest product of p[0 - i] with at least 1 cut
baseCase: M[1] = array[0] * array[1];
induction rule:
              M[i] = Math.max(Math.max(2,M[2]) * (i - 2), Math.max(3,M[3]) * (i - 3) ... )



 */




