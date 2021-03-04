package CSNotes.LinkedList;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

public class No445AddTwoNumbersII {
    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 自己写的，反转链表
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode r1 = reverseList(l1), r2 = reverseList(l2);
        int add = 0;
        ListNode newhead = new ListNode(0);
        ListNode n = newhead;
        while (r1 != null || r2 != null) {
            int va1 = r1 == null ? 0 : r1.val;
            int va2 = r2 == null ? 0 : r2.val;
            n.next = new ListNode((va1 + va2 + add) % 10);
            add = (va1 + va2 + add) / 10;
            n = n.next;
            r1 = r1 == null ? null : r1.next;
            r2 = r2 == null ? null : r2.next;
        }
        if (add > 0) n.next = new ListNode(add);
        return reverseList(newhead.next);
    }

    private ListNode reverseList(ListNode head) {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}
