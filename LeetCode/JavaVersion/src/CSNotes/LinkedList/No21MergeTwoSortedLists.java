package CSNotes.LinkedList;

public class No21MergeTwoSortedLists {
    // 自己写的
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2;
        ListNode newhead = new ListNode();
        ListNode returnnode = newhead;
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                newhead.next = t1;
                t1 = t1.next;
            } else {
                newhead.next = t2;
                t2 = t2.next;
            }
            newhead = newhead.next;
        }
        while (t1 != null) {
            newhead.next = t1;
            t1 = t1.next;
            newhead = newhead.next;
        }
        while (t2 != null) {
            newhead.next = t2;
            t2 = t2.next;
            newhead = newhead.next;
        }
        return returnnode.next;
    }

    // CS-Note参考代码
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

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
