package binaryTree;

public class LowestCommonAncestor2 {
    //one 和 two 不一定在树上的变种
    public static TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        TreeNode[] result = new TreeNode[1];
        lcaHelper(root, result, one, two);
        return result[0];
    }

    private static TreeNode lcaHelper(TreeNode root, TreeNode[] result,
                                      TreeNode one, TreeNode two) {
        if (root == null || result[0] != null) {
            return root;
        }

        TreeNode left = lcaHelper(root.left, result, one, two);
        TreeNode right = lcaHelper(root.right, result, one, two);

        if (left != null && right != null) {
            result[0] = root;
            return null;
        } else if (left != null || right != null) {
            if (root == one || root == two) {
                result[0] = root;
                return null;
            } else {
                return left == null ? right : left;
            }
        } else {
            if (root == one || root == two) {
                return root;
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println(lowestCommonAncestor(root, root.left, root.right).key);




    }

    private static TreeNode createTree() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.left = treeNode6;
//        treeNode3.right = treeNode7;
//        treeNode4.right = treeNode8;
        return treeNode1;

    }
}
