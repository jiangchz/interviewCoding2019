package randomlizationSampling;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianTracker {
    private PriorityQueue<Integer> largeHalf;
    private PriorityQueue<Integer> smallHalf;

    public MedianTracker() {
        largeHalf = new PriorityQueue<>();;
        smallHalf = new PriorityQueue<>(new Comparator<Integer>(){//bug
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
    }


    public void read1(int value) {
        if (smallHalf.size() == largeHalf.size()) {
            if (largeHalf.size() == 0 || value > smallHalf.peek()) {
                largeHalf.add(value);
            } else {
                largeHalf.add(smallHalf.remove());
                smallHalf.add(value);
            }
        } else { //smallHalf < largeHalf
            if (smallHalf.size() == 0 && value < largeHalf.peek()) {
                smallHalf.add(value);
            } else {
                smallHalf.add(largeHalf.remove());
                largeHalf.add(value);
            }
        }
    }

    public void read(int value) {
        // first tell which side to go
        if (largeHalf.size() == 0 || largeHalf.peek() < value) {
            largeHalf.add(value);
        } else {
            smallHalf.add(value);
        }
        //check whether both side are balanced
        if (smallHalf.size() > largeHalf.size()) {
            largeHalf.add(smallHalf.remove());
        } else if (largeHalf.size() - smallHalf.size() >= 2) {
            smallHalf.add(largeHalf.remove());
        }
    }

    public Double median() {
        if (smallHalf.size() == 0 && largeHalf.size() == 0) {
            return 0.0;
        }
        if (smallHalf.size() == largeHalf.size()) {
            return (largeHalf.peek() + smallHalf.peek()) / 2.0;
        } else {
            return largeHalf.peek() * 1.0;
        }

    }

    public static void main(String args[]) {
        MedianTracker medianTracker = new MedianTracker();
        medianTracker.read(1);
        medianTracker.read(2);
        medianTracker.read(3);
//        medianTracker.read(4);
//        medianTracker.read(100);
//        medianTracker.read(99);
//        medianTracker.read(50);
//        medianTracker.read(20);
//        medianTracker.read(5);

System.out.println(medianTracker.median());

    }
}
/*
  /**
     * Compares two {@code int} values numerically.
     * The value returned is identical to what would be returned by:
     * <pre>
     *    Integer.valueOf(x).compareTo(Integer.valueOf(y))
     * </pre>
     *
     * @param  x the first {@code int} to compare
     * @param  y the second {@code int} to compare
     * @return the value {@code 0} if {@code x == y};
     *         a value less than {@code 0} if {@code x < y}; and
     *         a value greater than {@code 0} if {@code x > y}
     * @since 1.7
     */
/*
    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
*/