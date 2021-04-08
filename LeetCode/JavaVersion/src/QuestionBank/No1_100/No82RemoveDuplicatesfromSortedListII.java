package QuestionBank.No1_100;

import java.util.HashMap;
import java.util.List;

public class No82RemoveDuplicatesfromSortedListII {
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

    // 写法1
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode newhead = new ListNode(0, head);
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode t = newhead.next;
        while (t != null) {
            map.put(t.val, map.getOrDefault(t.val, 0) + 1);
            t = t.next;
        }
        t = newhead;
        while (t != null) {
            ListNode tt = t.next;
            if (tt == null) break;
            if (map.get(tt.val) >= 2) {
                while (tt != null && map.get(tt.val) >= 2) tt = tt.next;
                t.next = tt;
            } else t = t.next;
        }
        return newhead.next;
    }

    // 写法2
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode newhead = new ListNode(0, head);
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode t = newhead.next;
        while (t != null) {
            map.put(t.val, map.getOrDefault(t.val, 0) + 1);
            t = t.next;
        }
        t = newhead;
        ListNode tt = head;
        while (tt != null) {
            if (map.get(tt.val) >= 2) tt = tt.next;
            else {
                t.next = new ListNode(tt.val, null);
                tt = tt.next;
                t = t.next;
            }
        }
        t.next = tt;
        return newhead.next;
    }

    // 写法3
    public ListNode deleteDuplicates3(ListNode head) {
        ListNode newhead = new ListNode(0, head);
        ListNode cur = newhead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val != cur.next.next.val) cur = cur.next;
            else {
                ListNode t = cur.next;
                while (t != null && t.val == cur.next.val) t = t.next;
                cur.next = t;
            }
        }
        return newhead.next;
    }

    // LeetCode 参考代码
    public ListNode deleteDuplicates4(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
