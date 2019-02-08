package stack;

import java.util.LinkedList;

public class SelectionSortWithTwoStacks {
    public static void selectionSortWithTwoStacks(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        if (s1 == null || s1.size() < 2) {
            return;
        }

        while (s1.size() != 0) {
            int gobalMin = Integer.MAX_VALUE;
            int counter = 0;
            while (s1.size() != 0) {
                int current = s1.pop();
                if (current < gobalMin) {
                    gobalMin = current;
                    s2.push(current);
                    counter = 1;
                } else if (current == gobalMin) {
                    s2.push(current);
                    counter++;
                } else {
                    s2.push(current);
                }
            }

            copyS2Back(s1, s2, counter, gobalMin);
        }
        copyResultBackTOS1(s1, s2);

    }
    private static void copyS2Back(final LinkedList<Integer> originalStack,
                                   final LinkedList<Integer> templateStack,
                                   int counter,
                                   int gobalMin) {
        while (templateStack.size() != 0) {
            int current = templateStack.peek();
            if (current > gobalMin) {
                templateStack.pop();
                originalStack.push(current);
            } else if (current == gobalMin) {
                templateStack.pop();
            } else if (current < gobalMin) {
                break;
            }
        }

        for (int index = 0; index < counter; index++) {
            templateStack.push(gobalMin);
        }
    }

    private static void copyResultBackTOS1(final LinkedList<Integer> original,
                                           final LinkedList<Integer> temp) {
        while (temp.size() != 0) {
            original.push(temp.pop());
        }
    }

    public static void main(String args[]) {
        LinkedList<Integer> test = new LinkedList<>();
        test.add(3);
        test.add(2);
        test.add(1);
        test.add(8);
        test.add(3);
        test.add(3);
        test.add(7);
        test.add(9);
        selectionSortWithTwoStacks(test);
        while (test.size() != 0) {
            System.out.print(test.pop() + " ");
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
//to do, 看看哪里能优化
*/