package QuestionBank.No201_300;

public class No206ReverseLinkedList {
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

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 递归版本
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newhead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}
