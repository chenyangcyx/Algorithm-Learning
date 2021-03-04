package CSNotes.LinkedList;
import java.util.LinkedList;

public class No234PalindromeLinkedList {
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

    // 自己写的
    // 反转链表，逐个比较
    public boolean isPalindrome1(ListNode head) {
        ListNode copy = copyLinkedList(head);
        ListNode copy_reverse = reverseLinkedList(copy);
        ListNode n1 = head, n2 = copy_reverse;
        while (n1 != null) {
            if (n1.val != n2.val) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    private ListNode copyLinkedList(ListNode ori) {
        ListNode copy = new ListNode(), t = copy;
        while (ori != null) {
            t.next = new ListNode(ori.val);
            ori = ori.next;
            t = t.next;
        }
        return copy.next;
    }

    private ListNode reverseLinkedList(ListNode head) {
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

    // 自己写的
    // 转换成列表，比较
    public boolean isPalindrome2(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        while (list.size() >= 2) {
            int first = list.pollFirst();
            int last = list.pollLast();
            if (first != last) return false;
        }
        return true;
    }

    // CS-Note参考代码
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;  // 偶数节点，让 slow 指向下一个节点
        cut(head, slow);                     // 切成两个链表
        return isEqual(head, reverse(slow));
    }

    private void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
