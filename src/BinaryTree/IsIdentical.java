package BinaryTree;

public class IsIdentical {
    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if(root1 == null || root2 == null) {
            return false;
        } else if (root1.key != root2.key) {
            return false;
        }
        return (isIdentical(root1.left, root2.right) && isIdentical(root1.right, root2.left)) ||
                (isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right));
    }
}

/*
Determine whether two binary trees structure are identical
                        8
                       /  \
                      4    5
                     /
                    7

        case1:   8a           and     8b
                 / \                  / \
                4a  5a               4b  5b
               /                     /
              7                      7
    OR   case2:
                 8a           and     8b
                 / \                  / \
                4a  5a               5b  4b
               /                          |
              7                           7

     time complexity is o(4 ^ log_2(n))  = o(n^2)
     branching factor equals 4 and log_2(n) levels

     Note:
      (isIdentical(root1.left, root2.right) && isIdentical(root1.right, root2.left)) ||
                (isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right));
*/
