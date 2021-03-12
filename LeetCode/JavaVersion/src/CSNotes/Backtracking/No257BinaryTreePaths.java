package CSNotes.Backtracking;

import java.util.*;

public class No257BinaryTreePaths {
    //    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, result, new StringBuilder());
        return result;
    }

    private void dfs(TreeNode root, List<String> result, StringBuilder sb) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            sb.append("->");
            int num_size = String.valueOf(root.left.val).length();
            dfs(root.left, result, sb);
            sb.delete(sb.length() - num_size - 2, sb.length());
        }
        if (root.right != null) {
            sb.append("->");
            int num_size = String.valueOf(root.right.val).length();
            dfs(root.right, result, sb);
            sb.delete(sb.length() - num_size - 2, sb.length());
        }
    }

    // CS-Note 参考代码
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<Integer> values = new ArrayList<>();
        backtracking(root, values, paths);
        return paths;
    }

    private void backtracking(TreeNode node, List<Integer> values, List<String> paths) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        if (isLeaf(node)) {
            paths.add(buildPath(values));
        } else {
            backtracking(node.left, values, paths);
            backtracking(node.right, values, paths);
        }
        values.remove(values.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }
}
