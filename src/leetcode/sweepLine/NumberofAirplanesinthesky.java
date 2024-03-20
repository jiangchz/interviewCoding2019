package leetcode.sweepLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//关键点： 1 需要把起点和重点都打散，所以建立一个node class
//        2 对于同一个时刻有多个飞机起飞，下降，应该先处理下降的情况。
//        3 comparator<>   compare不用<>
//        4 compare 从小到大排列  object1 - object2 从大到小 object2 - object1

public class NumberofAirplanesinthesky {
    /**
     * @param airplanes: An interval leetcode.array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        List<Node> nodes = new ArrayList<>();
        for (Interval interval : airplanes) {
            nodes.add(new Node(interval.start, 's'));
            nodes.add(new Node(interval.end, 'e'));
        }

        Collections.sort(nodes, new Comparator<Node>() {
            public int compare(Node node1, Node node2) {
                if (node1.time == node2.time) {
                    return node1.type - node2.type;
                } else {
                    return node1.time - node2.time;
                }
            }
        });

        //version 0 只有在第一次有下降的时候才需要更新gobalmax
//        int current = 0;
//        int gobalMax = 0;
//        int latestStart = -1;
//        for (Node node : nodes) {
//            if (node.type == 's') {
//                current++;
//                latestStart = node.time;
//            } else if (node.type == 'e') {
//                if (latestStart < node.time) {
//                    gobalMax = Math.max(gobalMax, current);
//                }
//                current--;
//            }
//        }
//        return gobalMax;

        //version1 无脑的每次都检查gobalMax
        int current = 0;
        int gobalMax = 0;
        for (Node node : nodes) {
            if (node.type == 's') {
                current++;
            } else if (node.type == 'e') {
                current--;
            }
            gobalMax = Math.max(gobalMax, current);
        }
        return gobalMax;


    }
    class Node {
        public int time;
        public char type;
        public Node (int time, char c) {
            this.time = time;
            this.type = c;
        }
    }
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}