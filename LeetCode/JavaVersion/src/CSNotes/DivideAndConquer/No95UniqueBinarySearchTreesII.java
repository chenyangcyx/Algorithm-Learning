package CSNotes.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class No95UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return getSubTree(1, n);
    }

    private List<TreeNode> getSubTree(int start, int end) {
        List<TreeNode> tree = new ArrayList<>();
        if (start > end) {
            tree.add(null);
            return tree;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> ltree = getSubTree(start, i - 1);
            List<TreeNode> rtree = getSubTree(i + 1, end);
            for (TreeNode lnode : ltree) {
                for (TreeNode rnode : rtree) {
                    TreeNode node = new TreeNode(i);
                    node.left = lnode;
                    node.right = rnode;
                    tree.add(node);
                }
            }
        }
        return tree;
    }

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
}
