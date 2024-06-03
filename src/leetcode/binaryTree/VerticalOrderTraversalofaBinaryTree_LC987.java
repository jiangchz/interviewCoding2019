package leetcode.binaryTree;

import java.util.*;

public class VerticalOrderTraversalofaBinaryTree_LC987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //limits[0]: left limit, limit[1]: right limit
        int[] limits = new int[]{0, 0};
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Node> pq =  bfs(root, limits);

        for (int i = 0; i < limits[1] - limits[0] + 1; i++) {
            result.add(new ArrayList<Integer>());
        }

        int i = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int colResultIndex = current.col + (-limits[0]);
            result.get(colResultIndex).add(current.treeNode.key);
        }
        return result;

    }

    private PriorityQueue<Node> bfs(TreeNode root, int[] limits) {
        Queue<Node> toVisit = new LinkedList<Node>();
        PriorityQueue<Node> result = new PriorityQueue<Node>();
        int row = 1;
        int col = 0;
        toVisit.add(new Node(row, col, root));

        while(!toVisit.isEmpty()){
            Node current = toVisit.poll();
            result.add(current);
            if (current.treeNode.left != null) {
                toVisit.add(new Node(current.row + 1, current.col - 1, current.treeNode.left));
                limits[0] = Math.min(limits[0], current.col - 1);
            }

            if (current.treeNode.right != null) {
                toVisit.add(new Node(current.row + 1, current.col + 1, current.treeNode.right));
                limits[1] = Math.max(limits[1], current.col + 1);
            }
        }

        return result;
    }

    private static class Node implements Comparable<Node>{
        int col;
        int row;
        int val;
        TreeNode treeNode;

        public Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public Node(int row, int col, TreeNode treeNode){
            this.row = row;
            this.col = col;
            this.treeNode = treeNode;
            this.val = treeNode.key;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }

        public int getVal() {
            return this.val;
        }

        public int compareTo(Node node){
            if (col != node.col) {
                return col - node.col;
            }

            if (row != node.row) {
                return row - node.row;
            }

            return val - node.val;
        }
    }

    public List<List<Integer>> verticalTraversal_v2_dfs(TreeNode root) {
        List<Node> nodes = new ArrayList<>();
        dfs(root, 0 , 0, nodes);
        Collections.sort(nodes,  Comparator.comparing(Node::getCol)
                .thenComparing(Node::getRow)
                .thenComparing(Node::getVal));

        LinkedList<List<Integer>> res = new LinkedList<>();
        int currentCol = Integer.MIN_VALUE;
        for (Node currentNode : nodes) {
            if (currentCol != currentNode.getCol()) {
                List<Integer> values = new LinkedList<>();
                values.add(currentNode.val);
                res.addLast(values);
                currentCol = currentNode.getCol();
            } else {
                res.getLast().add(currentNode.val);
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int row, int col, List<Node> nodes) {
        if (root == null) {
            return;
        }

        Node node = new Node(row, col, root.key);
        nodes.add(node);
        dfs(root.left, row + 1, col - 1, nodes);
        dfs(root.right, row + 1, col + 1, nodes);
    }
}

/**
 *
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 *
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 *
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
 *
 * Return the vertical order traversal of the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Column -1: Only node 9 is in this column.
 * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
 * Column 1: Only node 20 is in this column.
 * Column 2: Only node 7 is in this column.
 * Example 2:
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * Column -2: Only node 4 is in this column.
 * Column -1: Only node 2 is in this column.
 * Column 0: Nodes 1, 5, and 6 are in this column.
 *           1 is at the top, so it comes first.
 *           5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
 * Column 1: Only node 3 is in this column.
 * Column 2: Only node 7 is in this column.
 */
