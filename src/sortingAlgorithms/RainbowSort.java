package sortingAlgorithms;

public class RainbowSort {
    public static void main(String args[]) {
        int[] array = new int[] {0,0,-1,-1,0,1, -1, 0};
        rainbowSort(array);
        for (int num: array) {
            System.out.println(num);
        }
    }

    public static int[] rainbowSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int left = 0;
        int middle = 0;
        int right = array.length - 1;

        while (middle <= right) {
            if (array[middle] == -1) {
                swap(array, left++, middle++);
            } else if (array[middle] == 0) {
                middle++;
            } else {
                swap(array, middle, right--);
            }
        }
        return array;
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}

/*
Given an array of balls, where the color of the balls can only be Red, Green or Blue,
sort the balls such that all the Red balls are grouped on the left side,
all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side.
(Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

Examples

{0} is sorted to {0}
{1, 0} is sorted to {0, 1}
{1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
Assumptions

The input array is not null.
Corner Cases

What if the input array is of length zero? In this case, we should not do anything as well.

重点：
理解三个挡板/指针的物理意义
    left = 0； all letters to the left hand of "left" are  "-1"
    mid = 0; mid is actually the index. all letters in [left, mid) are all "0"
    right = array.length - 1; all letters to the right of "right" are "1"
=======
}

/*
Given an array of integers, sort the elements in the array in ascending order.
 The quick sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases

What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.
>>>>>>> 550c175... Add rainbowSort
*/