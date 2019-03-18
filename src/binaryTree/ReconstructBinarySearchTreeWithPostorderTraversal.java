package binaryTree;

public class ReconstructBinarySearchTreeWithPostorderTraversal {
    public TreeNode reconstruct(int[] post) {
        return recursiveContruct(post, 0, post.length - 1);
    }

    private TreeNode recursiveContruct(int[] post, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(post[right]);
        int leftEnd = --right;
        while (leftEnd >= 0 && post[leftEnd] > root.key) {
            leftEnd--;
        }
        root.left = recursiveContruct(post, left, leftEnd);
        root.right = recursiveContruct(post, leftEnd + 1, right);
        return root;
    }
}
