package leetcode.binaryTree;

public class TreeToDoubleLinkedList {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }

        Node dummy = new Node();
        dummy.left = findLeftMost(root);
        dummy.right = findRightMost(root);
        flatternTree(root);
        dummy.left.left = dummy.right;
        dummy.right.right = dummy.left;
        return dummy.left;
    }

    private Node findLeftMost(Node root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    private Node findRightMost(Node root) {
        while (root != null && root.right != null) {
            root = root.right;
        }
        return root;
    }

    private void flatternTree(Node root) {
        if (root == null) {
            return;
        }

        flatternTree(root.left);
        flatternTree(root.right);
        Node temp = root.left;
        root.left = findRightMost(temp);
        if (root.left != null) {
            root.left.right = root;
        }

        temp = root.right;
        root.right = findLeftMost(temp);
        if (root.right != null) {
            root.right.left = root;
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
