package CSNotes.LinkedList;

import java.util.Stack;

public class No206ReverseLinkedList {
    // 自己写的
    // 使用栈的形式
    public ListNode reverseList1_Stack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode t = head;
        while (t != null) {
            stack.add(t);
            t = t.next;
        }
        if (stack.isEmpty()) return null;
        ListNode newlist = stack.pop();
        ListNode listhead = newlist;
        while (!stack.isEmpty()) {
            newlist.next = stack.pop();
            newlist = newlist.next;
        }
        newlist.next = null;
        return listhead;
    }

    // 自己写的
    // 头插法
    public ListNode reverseList2_HeadInseart(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // CS-Note参考代码
    // 头插法
    public ListNode reverseList1(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    // CS-Note参考代码
    // 递归法
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList2(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    // 官方题解
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
