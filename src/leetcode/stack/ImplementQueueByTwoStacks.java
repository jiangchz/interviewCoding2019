package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueByTwoStacks {

    private Deque<Integer> in;
    private Deque<Integer> out;

    public ImplementQueueByTwoStacks() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public Integer poll() {
        move();
        return out.poll();
    }

    public void offer(int element) {
        in.offer(element);
    }

    public Integer peek() {
        move();
        return out.peek();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.size() == 0 && out.size() == 0;
    }

    private void move() {
        if (out.size() == 0) {
            while (in.size() != 0) {
                out.offer(in.poll());
            }
        }
    }


}
