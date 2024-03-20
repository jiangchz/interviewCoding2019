package leetcode.twoPointers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumNumberOfVisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        //step 1: check how many nodes on location and adjust the points
        List<Node> adjustedNodes = points.stream()
                .map(point -> new Node(point.get(0) - location.get(0), point.get(1) - location.get(1)))
                .filter(node -> node.x != 0 || node.y != 0)
                .sorted(Comparator.comparingDouble(Node::getAngle))
                .collect(Collectors.toList());
        int nodeCountOnLocation = points.size() - adjustedNodes.size();

        //step2: because we need to deal negative atan2 value and might have point range cross 4th and 1st Quadrant.
        //so we need to duplicate the nodes with angle + 2PI
        int size = adjustedNodes.size();
        for (int i = 0; i < size; i++) {
            Node node = adjustedNodes.get(i);
            adjustedNodes.add(new Node(node.x, node.y, node.angle + Math.PI * 2));
        }
        Collections.sort(adjustedNodes, Comparator.comparingDouble(Node::getAngle));

        //step3: sliding window
        int left = 0;
        int result = 0;
        double range = angle / 180.0 * Math.PI;
        for (int right = 0; right < adjustedNodes.size(); right++) {
            while (adjustedNodes.get(right).getAngle() - adjustedNodes.get(left).getAngle() > range) {
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        result += nodeCountOnLocation;
        return result;
    }

    private static class Node {
        public int x;
        public int y;
        public double angle;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.angle = Math.atan2(y, x);
        }

        public Node(int x, int y, double angle) {
            this.x = x;
            this.y = y;
            this.angle = angle;
        }

        public double getAngle() {
            return angle;
        }
    }
}
