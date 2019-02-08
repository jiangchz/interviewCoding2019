package stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStackWithOptimization {

    private Deque<Integer> data;
    private Deque<Pair> min;
    public static void main (String args[]) {
        MinStackWithOptimization minStackWithOptimization = new MinStackWithOptimization();
        minStackWithOptimization.push(5);
        minStackWithOptimization.pop();
        minStackWithOptimization.push(10);
        minStackWithOptimization.top();
        minStackWithOptimization.min();
    }

    public MinStackWithOptimization() {
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public int pop() {
        if (data.size() == 0) {
            return -1;
        }
        int peekValue = data.pop();
        if (peekValue == min.peek().value && data.size() == min.peek().size) {
            min.pop();
        }
        return peekValue;
    }

    public void push(int element) {
        if (min.size() == 0 || element < min.peek().value) {
            min.push(new Pair(element, data.size()));
        }
        data.push(element);
    }

    public int top() {
        if (data.size() == 0) {
            return -1;
        }
        return data.peek();
    }

    public int min() {
        if (data.size() == 0) {
            return -1;
        }
        return min.peek().value;
    }

    private class Pair {
        protected int value;
        //Size的物理意义是当最小值是value的时候的stack size！
        private int size;
        public Pair (int value, int size) {
            this.value = value;
            this.size = size;
        }
    }
}
