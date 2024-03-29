package QuestionBank.No1_100;

public class No21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newhead = new ListNode(0, null);
        ListNode t1 = l1, t2 = l2, tt = newhead;
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                tt.next = new ListNode(t1.val, null);
                t1 = t1.next;
            } else {
                tt.next = new ListNode(t2.val, null);
                t2 = t2.next;
            }
            tt = tt.next;
        }
        while (t1 != null) {
            tt.next = new ListNode(t1.val, null);
            t1 = t1.next;
            tt = tt.next;
        }
        while (t2 != null) {
            tt.next = new ListNode(t2.val, null);
            t2 = t2.next;
            tt = tt.next;
        }
        return newhead.next;
    }

    // LeetCode 参考代码1
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    // LeetCode 参考代码2
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
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
