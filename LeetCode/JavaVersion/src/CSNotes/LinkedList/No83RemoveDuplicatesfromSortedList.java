package CSNotes.LinkedList;

public class No83RemoveDuplicatesfromSortedList {
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

    // 自己写的代码
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode l = head;
        while (l != null) {
            ListNode l_t = l;
            while (l_t != null && l_t.val == l.val) l_t = l_t.next;
            l.next = l_t;
            l = l_t;
        }
        return head;
    }

    // CS-Note参考代码
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
