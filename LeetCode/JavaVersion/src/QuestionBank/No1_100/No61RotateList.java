package QuestionBank.No1_100;

public class No61RotateList {
    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode last = head;
        int count = 1;
        while (last.next != null) {
            last = last.next;
            count++;
        }
        // 将首尾节点相连
        last.next = head;
        // 定位到要截断的节点
        ListNode cut = head;
        int cut_index = count - (k + 1) % count;
//        System.out.println("count=" + count);
//        System.out.println("cut_index=" + cut_index);
        for (int i = 0; i < cut_index; i++) cut = cut.next;
        ListNode result = cut.next;
        cut.next = null;
        return result;
    }

    // LeetCode 参考代码
    public ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
