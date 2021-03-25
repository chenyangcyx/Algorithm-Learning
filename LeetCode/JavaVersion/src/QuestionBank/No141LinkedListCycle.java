package QuestionBank;

import java.util.*;

public class No141LinkedListCycle {
    //    Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode t1 = head, t2 = head.next;
        while (t1 != t2) {
            if (t2.next == null || t2.next.next == null) return false;
            t1 = t1.next;
            t2 = t2.next.next;
        }
        return true;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }

    // LeetCode 参考代码1
    public boolean hasCycle3(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // LeetCode 参考代码2
    public boolean hasCycle4(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
