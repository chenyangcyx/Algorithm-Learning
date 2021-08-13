package CSNotes.LinkedList;

public class No725SplitLinkedListinParts {
    // 自己写的
    public ListNode[] splitListToParts1(ListNode root, int k) {
        int length = 0;
        ListNode l = root;
        while (l != null) {
            length++;
            l = l.next;
        }
        ListNode[] result = new ListNode[k];
        int[] nodenum = new int[k];
        int ave = length / k;
        if (ave > 0) {
            for (int i = 0; i < k; i++) nodenum[i] = ave;
            if (length % k > 0) {
                for (int i = 0; i < length % k; i++) nodenum[i]++;
            }
        } else {
            for (int i = 0; i < length; i++) nodenum[i] = 1;
            for (int i = length; i < k; i++) nodenum[i] = 0;
        }
        for (int i = 0; i < k && root != null; i++) {
            result[i] = root;
            l = root;
            int num = nodenum[i];
            while (--num > 0) l = l.next;
            root = l.next;
            l.next = null;
        }
        return result;
    }

    // CS-Note参考代码
    public ListNode[] splitListToParts2(ListNode root, int k) {
        int N = 0;
        ListNode cur = root;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        int mod = N % k;
        int size = N / k;
        ListNode[] ret = new ListNode[k];
        cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            ret[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ret;
    }

    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
