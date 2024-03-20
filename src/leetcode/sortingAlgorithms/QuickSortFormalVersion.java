package leetcode.sortingAlgorithms;

public class QuickSortFormalVersion {
    public static void main(String args[]) {
        int[] array = new int[] {6,5,4,3,2,1};
        quickSort(array);
        for (int num: array) {
            System.out.println(num);
        }
    }

    public static int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int left = 0;
        int right = array.length - 1;
        quickSort(array, left, right);
        return array;
    }
    private static void quickSort(int array[], int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPosition = partition(array, left, right);
        quickSort(array, left, pivotPosition - 1);
        quickSort(array, pivotPosition + 1, right);
    }

    private static int partition(int array[], int left, int right) {
        int pivotIndex = getRandomPivotIndex(left, right);
        int pivot = array[pivotIndex];

        // swap the pivot to the rightmost position
        swap (array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[rightBound] >= pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }

    private static int getRandomPivotIndex(int left, int right) {
        return left + (int)(Math.random() * (right - left));
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}

/*
Given an leetcode.array of integers, sort the elements in the leetcode.array in ascending order.
 The quick sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases

What if the given leetcode.array is null? In this case, we do not need to do anything.
What if the given leetcode.array is of length zero? In this case, we do not need to do anything.

注意理解 "两个挡板，三个区间的思想"
[0，i): i的左侧不包含i，全都为比pivot小的数
[i，j]：i和j之间为位置探索区域
(j， n - 1]: j的右侧(不包含j), 全都为大于或等于pivot的数

时间 & 空间复杂度分析
                            1 3 5 7 9 8 6 4 2 0
                            /            \                        o(1)的时间
                      13579                 86420
                     /   \                 /     \                o(2)的时间
                135       79             864      20
                /\        /\              /\      /\              o(4)的时间
              13  5      7  9           86   4   2   0
              /\                                                  o(n)的时间，因为需要把每个数字都分成单独的一份
             1  3
                                                          time complexity for this level is
                                                          1 + 2 + 4 + ... + n = 2n - 1 = o(n)
             ==============================================
             13   5      79           86      4     02            o(n)的时间
                \/                      \    /
                135      79              468        02
                   \    /                   \      /              o(n)的时间
                    13579                    02468
                        \                    /                    o(n)的时间
                            012345678
                                                         time complexity for this level is
                                                          n + n + n +...+ n =  o(nlgn)

              空间复杂度分析类似，因为是冯诺伊曼体系，在一个时间点下，计算机只会有1个状态
              空间复杂度为call leetcode.stack 的size
                         1 3 5 7 9 8 6 4 2 0                      o(n)的空间
                            /
                      13579                                       o(n/2)的时间
                     /
                135                                               o(n/4)的时间
                /
              13                                                       。。。
              /
             1
                                                                  o(1)的空间，因为需要把每个数字都分成单独的一份
              总的空间复杂度为o(n)
*/