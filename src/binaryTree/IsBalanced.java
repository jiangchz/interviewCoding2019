package binaryTree;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight((root.right))) + 1;
    }
}


/*
balance tree: for every node, the height difference for left subtree and right subtree is not larger than 1.

This is not optimal solution. The key point for this problem is learn how to do time and space complexity analysis.
There have two type of "worse case", 1. The tree is a balance tree   2. The tree is a single line
time complexity: according to the code construct the recursion tree and add up all the time used by current level.

Case1:  Balanced tree.
                                root (n nodes) {getHeight(left), getHeight(right)}
                                                   n/2              n/2                     ...    n
                                    /            \
                              left(n/2)         right(n/2)
                            n/4      n/4       n/4     n/4                                  ...    n

           There have lgn levels. So the time complexity is o(nlgn)

           The call stack should looks like this, so the space complexity should by o(levels) = o(lgn)

                                | getHeight(current)        |
                                | ...                       |
                                | isBST(current.LEFT)       |
                                | isBST(current.LEFT)       |
                                | isBST(current.LEFT)       |
                                | isBST(current.LEFT)       |
                                | isBST(ROOT.LEFT)          |
                                | isBST(ROOT)               |
                                -----------------------------

Case2: Single line tree.
                             O
                            /
                           O
                          /
                         O
                        /
                       O

                         root (n nodes) {getHeight(left), getHeight(right)}
                                                   n             1                   ...    n

                         the heights were not equal at root level, so do not need to go down to recursive tree.
                         the time complexity is o(n)


                                | getHeight(current)        |
                                | getHeight(current)        |
                                | getHeight(current)        |
                                | getHeight(current)        |
                                | getHeight(current)        |
                                | getHeight(current)        |
                                | isBST(ROOT.LEFT)          |
                                | isBST(ROOT)               |
                                -----------------------------
                                the space complexity is o(level) = o(n)
 */