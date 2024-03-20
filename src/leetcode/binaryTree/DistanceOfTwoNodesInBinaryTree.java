package leetcode.binaryTree;

public class DistanceOfTwoNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        int result =  distance(node1, 4, 5);
        System.out.println(result);

    }

    private static boolean[] foundBoth = new boolean[1];
    public static int distance(TreeNode root, int k1, int k2) {
        if (root == null) {
            return 0;
        }
        return distanceHelper(root, k1, k2, foundBoth);
    }

    private static int distanceHelper(TreeNode root, int k1, int k2, boolean[] foundBoth) {
        int left = distance(root.left, k1, k2);
        int right = distance(root.right, k1, k2);
        int extra = foundBoth[0] == true ? 0 : 1;

        System.out.println("current val = " + root.key);

        if (left != 0 && right != 0) {
            System.out.println("case1");

            foundBoth[0] = true;
            System.out.println("foundBoth ==" + foundBoth[0]);

            return left + right;
        } else if (left != 0) {
            System.out.println("case2");
            System.out.println("extra ==" + extra);
            System.out.println("foundBoth ==" + foundBoth[0]);

            return left + extra;
        } else if (right != 0) {
            System.out.println("case3");

            return right + extra;
        } else if (root.key == k1 || root.key == k2) {
            System.out.println("case4");

            return 1;
        }

        return 0;

    }

}

