package randomlizationSampling;

import java.util.Random;

public class PerfectShuffle {
    public void shuffle1(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length - 1; i++) {
            int randomOffset = random.nextInt(array.length - i);
            swap(array, i, i + randomOffset);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void shuffle2(int[] array) {
        Random random = new Random();
        for (int i = array.length; i > 1; i--) {
            swap(array, i - 1, random.nextInt(i)); // bug swap(array, i, random.nextInt(i))
        }
    }

}

/*
Given an array of integers (without any duplicates),
shuffle the array such that all permutations are equally likely to be generated.

Assumptions

The given array is not null

Summary:
point1:

    linear scan the array to select a number with equal possibility each time. 1/n
    For example: 0 1 2 3 4 5 6

          for number at index 0: select 1 number from all 7 numbers with  1/7 possibility
          for number at index 1: select 1 number from all 6 remaining numbers with  1/6 possibility, total possibility is
               1/6 * 6/7 = 1/7
          for number at index 2: select 1 number from all 5 remaining numbers with  1/5 possibility, total possibility is
               1/5 * 5/6 * 6/7 = 1/7
      ...

point2: scan from the last index is cleaner since no need to offset


 */
