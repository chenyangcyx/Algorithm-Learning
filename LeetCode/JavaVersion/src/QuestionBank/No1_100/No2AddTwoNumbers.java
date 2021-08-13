package QuestionBank.No1_100;

public class No2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null);
        ListNode tt = head, h1 = l1, h2 = l2;
        int add = 0;
        while (h1 != null && h2 != null) {
            int sum = h1.val + h2.val + add;
            add = sum / 10;
            ListNode t = new ListNode(sum % 10, null);
            tt.next = t;
            tt = t;
            h1 = h1.next;
            h2 = h2.next;
        }
        while (h1 != null) {
            int sum = h1.val + add;
            add = sum / 10;
            ListNode t = new ListNode(sum % 10, null);
            tt.next = t;
            tt = t;
            h1 = h1.next;
        }
        while (h2 != null) {
            int sum = h2.val + add;
            add = sum / 10;
            ListNode t = new ListNode(sum % 10, null);
            tt.next = t;
            tt = t;
            h2 = h2.next;
        }
        if (add != 0) {
            ListNode t = new ListNode(add, null);
            tt.next = t;
        }
        return head.next;
    }

    // LeetCode 参考代码
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
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
