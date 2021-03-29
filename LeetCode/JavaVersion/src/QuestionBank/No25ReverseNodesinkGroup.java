package QuestionBank;

import java.util.List;

public class No25ReverseNodesinkGroup {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newhead = new ListNode(0, head);
        ListNode next_handle = newhead, prehead = newhead;
        while (true) {
            boolean success = true;
            for (int i = 0; i < k; i++) {
                if (next_handle == null || next_handle.next == null) {
                    success = false;
                    break;
                }
                next_handle = next_handle.next;
            }
            if (!success) break;
            ListNode next_group_first = next_handle.next;
            next_handle.next = null;
            next_handle = prehead.next;
            ListNode cur_list_first = reverseNode(prehead.next);
            prehead.next.next = next_group_first;
            prehead.next = cur_list_first;
            prehead = next_handle;
        }
        return newhead.next;
    }

    private ListNode reverseNode(ListNode root) {
        ListNode pre = null, cur = root;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

// LeetCode 参考代码
/*
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
*/