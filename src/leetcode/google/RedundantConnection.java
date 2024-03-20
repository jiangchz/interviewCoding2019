package leetcode.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RedundantConnection {
    Set<Integer> seen = new HashSet();
    int MAX_EDGE_VAL = 1000;

    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
        for (int i = 0; i <= MAX_EDGE_VAL; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] edge: edges) {
            seen.clear();
            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() &&
                    dfs(graph, edge[0], edge[1])) {
                return edge;
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        throw new AssertionError();
    }
    public boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
        if (!seen.contains(source)) {
            seen.add(source);
            if (source == target) return true;
            for (int nei: graph[source]) {
                if (dfs(graph, nei, target)) return true;
            }
        }
        return false;
    }

    //wrong version
        public int[] findRedundantConnection1(int[][] edges) {
            ArrayList<Integer>[] graph = connectGraph(edges);
            Set<Integer> visited = new HashSet<>();
            return  SearchForCycle(graph, visited, 1000);
        }

        //leetcode.dfs
        private int[] SearchForCycle(ArrayList<Integer>[] graph,
                                     Set<Integer> visited,
                                     int startIndex) {
            for (int i = startIndex; i > 0; i--) {
                int from = i;
                if (graph[i] == null) {
                    continue;
                }
                visited.add(from);
                for (int to : graph[from]) {
                    if (visited.contains(to)) {
                        return new int[]{to, from};
                    }
                    SearchForCycle(graph, visited, to);
                }
                visited.remove(visited.size() - 1);
            }
            return new int[] {-1, -1};
        }

        private ArrayList<Integer>[] connectGraph(int[][] edges) {
            ArrayList<Integer>[] graph = new ArrayList[1001];
            for (int i = 0; i < edges.length; i++) {
                int from = edges[i][0];
                int to = edges[i][1];
                if (graph[from] == null) {
                    ArrayList<Integer> neighbors = new ArrayList<>();
                    graph[from] = neighbors;
                }
                if (graph[to] == null) {
                    ArrayList<Integer> neighbors = new ArrayList<>();
                    graph[to] = neighbors;
                }
                graph[from].add(to);
                graph[to].add(from);
            }
            return graph;
        }
    //练习
    public int[] findRedundantConnection3(int[][] edges) {
        int[] parent = new int[1001];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (find(parent, from) == find(parent, to)) {
                return edge;
            } else {
                parent[find(parent, from)] = find(parent, to);
            }
        }
        return new int[2];
    }

    private int find(int[] parent, int from) {
        if (from != parent[from]) {
            parent[from] = find(parent, parent[from]);
        }
        return parent[from];
    }

}
