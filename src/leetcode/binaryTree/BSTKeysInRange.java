package leetcode.binaryTree;

public class BSTKeysInRange {
    public void printBSTInRange(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        printBSTHelper(root.left, min, max);
    }

    private void printBSTHelper(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        //todo rewrite it on Feb17th
    }
}

/*
wrong version:

        if (root.key >= max) {
            printBSTHelper(root.left, min, root.key);
        } else if (root.key <= min) {
            printBSTHelper(root.left, min, root.key);
        }

        printBSTHelper(root.left, min, root.key);
        printBSTHelper(root.right, root.key, max);

        if (root.key >= min && root.key <= max) {
            System.out.println(root.key);
        }

bug1: Pruning condition should be
        if (have the condition to go the left branch) {
            left
        }
bug2: Since no duplicate keys and if root.key == min, should not recurse to left subtree.
bug3:
        print BST number in increasing order, should use in order
        Which means:
            left
            root
            right
 */
