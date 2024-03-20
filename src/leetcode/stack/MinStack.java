package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    private Deque<Integer> data;
    private Deque<Integer> min;

    public MinStack() {
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public int pop() {
        if (data.size() == 0) {
            return -1;
        }
        if (data.peek() == min.peek())
        min.pop();
        return data.pop();
    }

    public void push(int element) {
        if (data.size() == 0 || element <= min.peek()) {
            min.push(element);
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
        return min.peek();
    }
}
