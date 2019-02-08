package stack;

import java.util.LinkedList;

public class SelectionSortWithThreeStacks {
    public static void selectionSortWithThreeStacks(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();

        if (s1 == null || s1.size() < 2) {
            return;
        }

        while (s1.size() != 0) {
            int gobalMin = copyS1toS2(s1, s2);
            copyS2Back(s1, s2, s3, gobalMin);
        }

        copyResultBackTOS1(s1, s2, s3);

    }

    private static int copyS1toS2(final LinkedList<Integer> stackFrom,
                                  final LinkedList<Integer> stackTo) {
        int gobalMin = Integer.MAX_VALUE;
        while (stackFrom.size() != 0) {
            int current = stackFrom.pop();
            if (current < gobalMin) {
                gobalMin = current;
            }
            stackTo.push(current);
        }
        return gobalMin;
    }

    private static void copyS2Back(final LinkedList<Integer> originalStack,
                                   final LinkedList<Integer> templateStack,
                                   final LinkedList<Integer> resultStack,
                                   int gobalMin) {
        while (templateStack.size() != 0) {
            int current = templateStack.pop();
            if (current == gobalMin) {
                resultStack.push(current);
            } else {
                originalStack.push(current);
            }
        }
    }

    private static void copyResultBackTOS1(final LinkedList<Integer> original,
                                           final LinkedList<Integer> temp,
                                           final LinkedList<Integer> result) {
        while(result.size() != 0) {
            temp.push(result.pop());
        }
        while(temp.size() != 0) {
            original.push(temp.pop());
        }
    }

    public static void main(String args[]) {
        LinkedList<Integer> test = new LinkedList<>();
        test.add(3);test.add(2);test.add(1);test.add(8);test.add(3);test.add(3);test.add(7);test.add(9);
        selectionSortWithThreeStacks(test);
        while (test.size() != 0) {
            System.out.print(test.pop() + " ");
        }
    }
}

/*
Given one stack with integers, sort it with two additional stacks (total 3 stacks).

After sorting the original stack should contain the sorted integers and
from top to bottom the integers are sorted in ascending order.

Assumptions:

The given stack is not null.
Requirements:

No additional memory, time complexity = O(nlog(n)).

Note:
1.时间复杂度为o(n^2)!
2. 注意判断大小条件时候 Integer.MIN_VALUE 和 MAX_VALUE的选择
3. 注意stack的拷贝一次以后顺序是反向的。
*/