package binaryTree;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversalBST {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // !!!注意中序遍历需要用stack！
        Deque<TreeNode> visitedStack = new LinkedList<>();

        while (visitedStack.size() != 0 || root != null) {

            if (root != null) {
                visitedStack.push(root);
                root = root.left;
            } else {
                root = visitedStack.pop();
                result.add(root.key);
                root = root.right;
            }
        }
        return result;
    }

}

/*
Implement an iterative, pre-order traversal of a given binary tree,
return the list of keys of each node in the tree as it is pre-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Pre-order traversal is [5, 3, 1, 4, 8, 11]

Corner Cases

What if the given binary tree is null? Return an empty list in this case.
How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4


 */
