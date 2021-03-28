package QuestionBank;

import java.util.LinkedList;

public class No173BinarySearchTreeIterator {
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

    // 自己写的方法1
    /*
    LinkedList<Integer> tree_data;

    public No173BinarySearchTreeIterator(TreeNode root) {
        tree_data = new LinkedList<>();
        tranverseTree(root);
    }

    private void tranverseTree(TreeNode root) {
        if (root == null) return;
        tranverseTree(root.left);
        tree_data.addLast(root.val);
        tranverseTree(root.right);
    }

    public int next() {
        return tree_data.pollFirst();
    }

    public boolean hasNext() {
        return !tree_data.isEmpty();
    }
    */

    // 自己写的方法2
    class MyNode {
        TreeNode node;
        boolean t_l = false;

        MyNode(TreeNode n) {
            this.node = n;
        }
    }

    LinkedList<MyNode> stack;

    public No173BinarySearchTreeIterator(TreeNode root) {
        stack = new LinkedList<>();
        stack.addLast(new MyNode(root));
    }

    public int next() {
        MyNode n = stack.peekLast();
        while (!n.t_l) {
            if (n.node.left != null) stack.addLast(new MyNode(n.node.left));
            n.t_l = true;
            n = stack.peekLast();
        }
        n = stack.pollLast();
        if (n.node.right != null) stack.addLast(new MyNode(n.node.right));
        return n.node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

// LeetCode 参考代码1
/*
class BSTIterator {
    private int idx;
    private List<Integer> arr;

    public BSTIterator(TreeNode root) {
        idx = 0;
        arr = new ArrayList<Integer>();
        inorderTraversal(root, arr);
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }
}
*/

// LeetCode 参考代码2
/*
class BSTIterator {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new LinkedList<TreeNode>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
*/