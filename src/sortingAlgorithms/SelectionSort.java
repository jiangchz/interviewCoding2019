package sortingAlgorithms;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SelectionSort {
    public int[] sortArray(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        for (int outerIndex = 0; outerIndex < array.length - 1; outerIndex++) {
            int localMin = outerIndex;
            for (int innerIndex = outerIndex + 1; innerIndex < array.length; innerIndex++) {
                localMin = array[innerIndex] < array[localMin] ? innerIndex : localMin;
            }
            swap(array, localMin, outerIndex);
        }
        return array;

    }
    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public int[] selectionSortWith3Stacks(int[] array) {
        Deque<Integer> originalStack = new LinkedList<>();
        Deque<Integer> templeStack = new LinkedList<>();
        Deque<Integer> resultStack = new LinkedList<>();

        for (int current : array) {
            originalStack.addLast(current);
        }
        while (originalStack.size() != 0) {
            int gobalMax = Integer.MIN_VALUE;
            int gobalMaxCounter = 0;
            while (originalStack.size() != 0) {
                int currentValue = originalStack.removeLast();
                if (currentValue > gobalMax) {
                    gobalMax = currentValue;
                    gobalMaxCounter = 1;
                } else if (currentValue == gobalMax) {
                    gobalMaxCounter++;
                }
                templeStack.addLast(currentValue);
            }

            for (int i = 0; i < gobalMaxCounter; i++) {
                resultStack.addLast(gobalMax);
            }

            while(templeStack.size() != 0) {
                int currentValue = templeStack.removeLast();
                if (currentValue < gobalMax) {
                    originalStack.addLast(currentValue);
                }
            }
        }

        int i = 0;
        while (resultStack.size() != 0) {
            array[i++] = resultStack.removeLast();
        }

        return array;
    }

    public static int[] selectionSortWith3StacksFuxi(int[] array) {
        Deque<Integer> originalStack = new LinkedList<>();
        for (int i : array) {
            originalStack.push(i);
        }
        Deque<Integer> templeStack = new LinkedList<>();
        Deque<Integer> resultStack = new LinkedList<>();

        while (originalStack.size() != 0 || templeStack.size() != 0) {
            //swap if template stack is not empty
            if (originalStack.size() == 0) {
                Deque<Integer> temple = templeStack;
                templeStack = originalStack;
                originalStack = temple;
            }

            int globalMin = Integer.MAX_VALUE;
            while (originalStack.size() != 0) {
                int current = originalStack.pop();
                if (resultStack.size() != 0 && current == resultStack.peek()) {
                    continue;
                }
                globalMin = Math.min(current, globalMin);
                templeStack.push(current);
            }
            resultStack.push(globalMin);
        }

        resultStack.pop();
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = resultStack.poll();
        }
        return array;
    }

    public static int[] selectionSortWith3StacksDuplicate(int[] array) {
        Deque<Integer> originalStack = new LinkedList<>();
        for (int i : array) {
            originalStack.push(i);
        }
        Deque<Integer> templeStack = new LinkedList<>();
        Deque<Integer> resultStack = new LinkedList<>();

        while (originalStack.size() != 0 || templeStack.size() != 0) {
            //swap if template stack is not empty
            if (originalStack.size() == 0) {
                Deque<Integer> temple = templeStack;
                templeStack = originalStack;
                originalStack = temple;
            }

            int globalMin = Integer.MAX_VALUE;
            int minCounter = 0;
            while (originalStack.size() != 0) {
                int current = originalStack.pop();
                if (resultStack.size() != 0 && current == resultStack.peek()) {
                    continue;
                }
                if (current < globalMin) {
                    globalMin = current;
                    minCounter = 1;
                } else if (current == globalMin) {
                    minCounter++;
                }

                templeStack.push(current);
            }

            for (int i = 0; i < minCounter; i++) {
                resultStack.push(globalMin);
            }
        }

        while (resultStack.peek() == Integer.MAX_VALUE) {
            resultStack.pop();
        }

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = resultStack.poll();
        }
        return array;
    }

    public static int[] selectionSortWith2Stacks(int[] array) {
        Deque<Integer> originalStack = new LinkedList<>();
        for (int i : array) {
            originalStack.push(i);
        }
        Deque<Integer> resultStack = new LinkedList<>();

        int resultCountInStack = 0;
        while (originalStack.size() != 0) {
            //move numbers to resultStack
            int globalMin = Integer.MAX_VALUE;
            int minCount = 0;
            while (originalStack.size() != 0) {
                int current = originalStack.pop();
                if (current < globalMin) {
                    globalMin = current;
                    minCount = 1;
                } else if (current == globalMin){
                    minCount++;
                }
                resultStack.push(current);
            }
            //move numbers back from result stack
            while (resultStack.size() > resultCountInStack) {
                int current = resultStack.pop();
                if (current > globalMin) {
                    originalStack.push(current);
                }
            }

            for (int i = 0; i < minCount; i++) {
                resultStack.push(globalMin);
            }
            resultCountInStack += minCount;
        }

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = resultStack.poll();
        }
        return array;
    }

    public static void main (String[] args) {
        int[] test = {2, 2, 2, 2, 1, 6, 1, 1,3, 3, 5, 7};
        selectionSortWith2Stacks(test);
        for (int i  : test) {
            System.out.print(i + " ");
        }
    }
}

/*
Given an array of integers, sort the elements in the array in ascending order.
The selection sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases

What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.

*/