package CSNotes.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class No160IntersectionofTwoLinkedLists {
    // 自己写的
    // 使用hashset容器
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> allnode = new HashSet<>();
        ListNode t1 = headA;
        while (t1 != null) {
            allnode.add(t1);
            t1 = t1.next;
        }
        ListNode t2 = headB;
        while (t2 != null) {
            if (allnode.contains(t2)) return t2;
            t2 = t2.next;
        }
        return null;
    }

    // CS-Note参考代码
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
