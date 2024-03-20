package leetcode.heap;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

// Java program to implement Max Heap
public class PartitionNumbers {
    public static void main(String[] arg) {
        String s = "1(2)23#(3)";
        int[] result = decodingString(s);
        for (int num : result) {
            System.out.print(num + ", ");
        }

    }

    public static int[] decodingString(String s) {
        //1226#24#
        int[] result = new int[26];

        char[] chars = s.toCharArray();

        int index = 0;
        while (index < chars.length) {
            int toAddNum;
            if (isSingleDigitNum(chars, index)) {
                toAddNum = toNumber(chars[index]) * 10 + toNumber(chars[index + 1]);
                index += 3;
            } else {
                toAddNum = toNumber(chars[index]);
                index += 1;
            }

            int duplicationCount = 1;
            if (index < chars.length && chars[index] == '(') {
                int count = 0;
                index++;
                while (chars[index] != ')') {
                    count = count * 10 + toNumber(chars[index]);
                    index++;
                }
                index++;
                duplicationCount = count;
            }
            System.out.println("to add number =" + toAddNum);
            System.out.println("to add duplicationCount =" + duplicationCount);

            result[toAddNum - 1] += duplicationCount;
        }
        return result;
    }

    private static boolean isSingleDigitNum(char[] chars, int startIndex) {
        int endIndex = startIndex + 2;
        if (endIndex >= chars.length) {
            return false;
        }

        if (chars[endIndex] != '#' || isValueOverLimit(chars, startIndex)) {
            return false;
        }
        return true;
    }

    private static boolean isValueOverLimit(char[] chars, int startIndex) {
        return toNumber(chars[startIndex]) * 10 + toNumber(chars[startIndex + 1]) > 26;
    }

    private static final int toNumber(char c) {
        return c - '0';
    }

    private static Map<Character, Character> pairs = Map.of('(', ')', '[', ']', '{', '}');

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if (pairs.keySet().contains(c)) {
                stack.push(pairs.get(c));
            } else if (stack.isEmpty() || c != stack.peek()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static List<List<Integer>> partitionNumbers(int[] inputs, int bucket) {
        Arrays.sort(inputs);
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Node> nodeQueue = new PriorityQueue<>((n1, n2) -> n1.total - n2.total);

        for (int i = 0; i < bucket; i++) {
            nodeQueue.add(new Node());
        }

        for (int i = inputs.length - 1; i >= 0; i--) {
            int currentVal = inputs[i];
            Node currentNode = nodeQueue.poll();
            currentNode.add(currentVal);
            nodeQueue.add(currentNode);
        }

        while (!nodeQueue.isEmpty()) {
            result.add(nodeQueue.poll().numbers);
        }
        return result;
    }

    private static class Node {
        public List<Integer> numbers;
        public int total;

        public Node() {
            numbers = new ArrayList<>();
            total = 0;
        }

        public void add(int value) {
            numbers.add(value);
            total += value;
        }
    }
}

