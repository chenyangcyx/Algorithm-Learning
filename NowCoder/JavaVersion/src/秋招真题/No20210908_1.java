package 秋招真题;

import java.util.LinkedList;
import java.util.Scanner;

public class No20210908_1 {
    static class Node {
        int no;
        int val;
        Node left = null;
        Node right = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Node[] node_list = new Node[N];
        String line1 = sc.nextLine();
        String[] sp1 = line1.split(" ");
        for (int i = 0; i < N; i++) {
            node_list[i] = new Node();
            node_list[i].no = i;
            node_list[i].val = Integer.parseInt(sp1[i]);
        }
        while (sc.hasNext()) {
            String _line = sc.nextLine();
            String[] _line_sp = _line.split(" ");
            int node_num = Integer.parseInt(_line_sp[0]);
            int child_num = Integer.parseInt(_line_sp[1]);
            if (node_list[node_num].left == null) {
                node_list[node_num].left = node_list[child_num];
            } else {
                node_list[node_num].right = node_list[child_num];
            }
        }
        int max_cut_node = 1;
        int max_value = Math.abs(calOldTreeSum(node_list[0], 1) - calNewTreeSum(node_list, 1));

        for (int i = 2; i < node_list.length; i++) {
            int _node = i;
            int _value = Math.abs(calOldTreeSum(node_list[0], _node) - calNewTreeSum(node_list, _node));
            if (_value > max_value) {
                max_value = _value;
                max_cut_node = _node;
            }
        }
        System.out.println(max_cut_node);
    }

    static int calOldTreeSum(Node root, int cut_node_no) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            Node now_node = queue.pollFirst();
            sum += now_node.val;
            if (now_node.left != null && now_node.left.no != cut_node_no) {
                queue.addLast(now_node.left);
            }
            if (now_node.right != null && now_node.right.no != cut_node_no) {
                queue.addLast(now_node.right);
            }
        }
        return sum;
    }

    static int calNewTreeSum(Node[] node_list, int cut_node_num) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node_list[cut_node_num]);
        int sum = 0;
        while (!queue.isEmpty()) {
            Node now_node = queue.pollFirst();
            sum += now_node.val;
            if (now_node.left != null) {
                queue.addLast(now_node.left);
            }
            if (now_node.right != null) {
                queue.addLast(now_node.right);
            }
        }
        return sum;
    }
}
