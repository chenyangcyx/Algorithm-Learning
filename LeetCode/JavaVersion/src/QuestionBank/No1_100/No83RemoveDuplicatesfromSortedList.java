package QuestionBank.No1_100;

public class No83RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead = new ListNode(0, head);
        ListNode cur = newhead;
        while (cur.next != null) {
            ListNode next = cur.next;
            while (next.next != null && next.next.val == cur.next.val) next = next.next;
            cur.next = next;
            cur = next;
        }
        return newhead.next;
    }

    // LeetCode 参考代码
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

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
}
