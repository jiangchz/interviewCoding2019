package leetcode.randomlizationSampling;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage_LC346 {
    private double total;
    private Deque<Integer> numbers;
    private int size;

    public void MovingAverage(int size) {
        this.size = size;
        numbers = new LinkedList<>();
        total = 0;
    }

    public double next(int val) {
        total += val;
        numbers.addLast(val);
        if (numbers.size() > size) {
            total -= numbers.removeFirst();
        }
        return total / numbers.size();
    }
}
