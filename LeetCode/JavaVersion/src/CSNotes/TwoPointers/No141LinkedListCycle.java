package CSNotes.TwoPointers;

public class No141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null && p2.next != null) {
            if (p1 == p2) return true;
            else {
                p1 = p1.next;
                p2 = p2.next.next;
            }
        }
        return false;
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
