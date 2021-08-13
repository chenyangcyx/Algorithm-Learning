package CSNotes.LinkedList;

import java.util.Stack;

public class No19RemoveNthNodeFromEndofList {
    // 自己写的代码
    // 链表遍历
    public ListNode removeNthFromEnd1_traverse(ListNode head, int n) {
        int length = 0;
        ListNode l = head;
        while (l != null) {
            length++;
            l = l.next;
        }
        int pos = length - n + 1;
        ListNode newhead = new ListNode(-1, head);
        length = 0;
        l = newhead;
        while (l != null) {
            length++;
            if (length == pos) {
                l.next = l.next.next;
                break;
            }
            l = l.next;
        }
        return newhead.next;
    }

    // 自己写的代码
    // 栈的方式
    public ListNode removeNthFromEnd2_stack(ListNode head, int n) {
        ListNode newhead = new ListNode(-1, head), l = newhead;
        Stack<ListNode> stack = new Stack<>();
        while (l != null) {
            stack.add(l);
            l = l.next;
        }
        while (n-- > 0) stack.pop();
        ListNode t = stack.peek();
        t.next = t.next.next;
        return newhead.next;
    }

    // CS-Note参考代码
    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
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
