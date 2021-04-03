package QuestionBank;

import java.util.HashSet;
import java.util.LinkedList;

public class No124BinaryTreeMaximumPathSum {
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

    // 自己写的代码1
/*
    int max_length = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max_length;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left_num = Integer.max(dfs(node.left), 0);
        int right_num = Integer.max(dfs(node.right), 0);
        max_length = Integer.max(max_length, node.val + left_num + right_num);
        return node.val + Integer.max(left_num, right_num);
    }
*/

    // 自己写的代码2
    // 带最大路径
    int max_length = Integer.MIN_VALUE;
    HashSet<TreeNode> result_set = new HashSet<>();

    class NodeRoute {
        TreeNode node;
        LinkedList<TreeNode> list = new LinkedList<>();
        int gain_num = 0;

        public NodeRoute(TreeNode n, LinkedList<TreeNode> l, int g) {
            this.node = n;
            this.list = l;
            this.gain_num = g;
        }
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        for (TreeNode n : result_set) System.out.print(n.val + " ");
        return max_length;
    }

    private NodeRoute dfs(TreeNode node) {
        if (node == null) {
            return new NodeRoute(null, new LinkedList<TreeNode>(), 0);
        }
        NodeRoute return_nr = new NodeRoute(node, new LinkedList<>(), node.val);
        NodeRoute left_node_result = dfs(node.left);
        int left_num = 0;
        if (left_node_result.gain_num > 0) {
            left_num = left_node_result.gain_num;
        }
        NodeRoute right_node_result = dfs(node.right);
        int right_num = 0;
        if (right_node_result.gain_num > 0) {
            right_num = right_node_result.gain_num;
        }
        if (node.val + left_num + right_num > max_length) {
            max_length = node.val + left_num + right_num;
            result_set.clear();
            result_set.addAll(left_node_result.list);
            result_set.addAll(right_node_result.list);
            result_set.add(node);
        }
        if (left_num >= right_num) {
            return_nr.list = new LinkedList<>(left_node_result.list);
            return_nr.gain_num += left_node_result.gain_num;
        } else {
            return_nr.list = new LinkedList<>(right_node_result.list);
            return_nr.gain_num += right_node_result.gain_num;
        }
        return_nr.list.add(node);
        return return_nr;
    }
}


// LeetCode 参考代码
/*
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
*/