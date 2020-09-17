package dynamicPrograming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ModerLudo1 {
    public int modernLudo(int length, int[][] connections) {
        final Map<Integer, Set<Integer>> routes = buildRoutes(connections);

        //initialization
        int[] jumpsNeeded = new int[length + 1];
        jumpsNeeded[1] = 0;

        for (int i = 2; i <= length; i++) {
            jumpsNeeded[i] = length;
        }

        if (routes.containsKey(1)) {
            Set<Integer> pointsRouteTo = routes.get(length);
            for (int pointRouteTo : pointsRouteTo) {
                jumpsNeeded[pointRouteTo] = 0;
            }
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= 6 && i + j <= length; j++) {
                int currentPosition = i + j;
                jumpsNeeded[currentPosition] = Math.min(jumpsNeeded[i] + 1, jumpsNeeded[currentPosition]);
                if (routes.containsKey(currentPosition)) {
                    Set<Integer> pointsRouteTo = routes.get(currentPosition);
                    for (int pointRouteTo : pointsRouteTo) {
                        jumpsNeeded[pointRouteTo] = Math.min(jumpsNeeded[currentPosition], jumpsNeeded[pointRouteTo]);
                    }

                }
            }

        }
        return jumpsNeeded[length];
    }


    private static Map<Integer, Set<Integer>> buildRoutes(int[][] connections) {
        final Map<Integer, Set<Integer>> revertedRoutes = new HashMap<>(connections.length);
        for (int[] mapping : connections) {
            revertedRoutes.putIfAbsent(mapping[0], new HashSet<>());
            revertedRoutes.get(mapping[0]).add(mapping[1]);
        }
        return revertedRoutes;
    }
}

/*
1565. Modern Ludo I
中文English
There is a one-dimensional board with a starting point on the far left side of the board and an end point on the far right side of the board. There are several positions on the board that are connected to other positions, ie if A is connected to B, then when chess falls at position A, you can choose whether to move the chess from A to B. And the connection is one way, which means that the chess cannot move from B to A. Now given the length and connections of the board, and you have a six-sided dice(1-6), output the minimum steps to reach the end point.

样例
Example1

Input: length = 10 and connections = [[2, 10]]
Output: 1
Explanation:
1->2 (dice)
2->10(for free)
Example2

Input: length = 15 and connections = [[2, 8],[6, 9]]
Output: 2
Explanation:
1->6 (dice)
6->9 (for free)
9->15(dice)
注意事项
the index starts from 1.
length > 1
The starting point is not connected to any other location
connections[i][0] < connections[i][1]
 */