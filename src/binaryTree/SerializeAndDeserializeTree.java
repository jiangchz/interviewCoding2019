package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeTree {
    //ref： https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/discuss/
    // 190318/Serialize-and-Deserialize-Binary-and-N-ary-Tree-Summary
    // for binary tree
    private static final String EMPTY_VALUE = "X";
    private static final String SPLITER = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(EMPTY_VALUE);
            sb.append(SPLITER);
        } else {
            sb.append(root.key);
            sb.append(SPLITER);
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(SPLITER);
        return buildTreeHelper(dataArray, 0);
    }

    private TreeNode buildTreeHelper(String[] dataArray, int index) {
        String current = dataArray[index];
        if(current.equals(EMPTY_VALUE)){
            return null;
        } else {
            int val = Integer.valueOf(current);
            TreeNode currentNode = new TreeNode(val);
            currentNode.left = buildTreeHelper(dataArray, index + 1);
            currentNode.right = buildTreeHelper(dataArray, index + 2);
            return currentNode;
        }
    }


    // for n-ary tree
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper2(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(EMPTY_VALUE);
            sb.append(SPLITER);
        } else {
            sb.append(root.key);
            sb.append(SPLITER);
            sb.append(root.children.size());
            sb.append(SPLITER);
            for (TreeNode child : root.children) {
                serializeHelper2(child, sb);
            }
        }
    }

    public TreeNode deserialize2(String data) {
        String[] dataArray = data.split(SPLITER);
        return buildTreeHelper(dataArray, 0);
    }

    private TreeNode buildTreeHelper2(String[] dataArray, int index) {
        String currentVal = dataArray[index];
        if(currentVal.equals(EMPTY_VALUE)){
            return null;
        }

        int val = Integer.valueOf(currentVal);
        int childCount = Integer.valueOf(dataArray[index + 1]);

        TreeNode currentNode = new TreeNode(val);
        currentNode.children = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            currentNode.children.add(buildTreeHelper2(dataArray, index + 2 + i));
        }
        return currentNode;
    }


    // Version use Deque instead of array with index
    public String serialize3(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper3(root, sb);
        return sb.toString();
    }

    private void serializeHelper3(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(EMPTY_VALUE);
            sb.append(SPLITER);
        } else {
            sb.append(root.key);
            sb.append(SPLITER);
            sb.append(root.children.size());
            sb.append(SPLITER);
            for (TreeNode child : root.children) {
                serializeHelper(child, sb);
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize3(String data) {
        Deque<String> dataArray = new LinkedList<>(Arrays.asList(data.split(SPLITER)));
        return deserializeHelper3(dataArray);
    }

    private TreeNode deserializeHelper3(Deque<String> dataArray) {
        String rootValue = dataArray.removeFirst();

        if (rootValue.equals(EMPTY_VALUE)) {
            return null;
        }

        int childSize = Integer.valueOf(dataArray.removeFirst());
        TreeNode root = new TreeNode(Integer.valueOf(rootValue));
        root.children = new ArrayList<TreeNode>();
        for (int i = 0; i < childSize; i++) {
            root.children.add(deserializeHelper3(dataArray));
        }
        return root;
    }
}