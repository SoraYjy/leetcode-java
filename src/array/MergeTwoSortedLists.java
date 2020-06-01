package array;

import list.model.ListNode;

/**
 *  21. Merge Two Sorted Lists
 *  https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        merge(dummy, l1, l2);
        return dummy.next;
    }

    private void merge(ListNode cur, ListNode l1, ListNode l2) {
        if (l1 == null) {
            cur.next = l2;
            return;
        }
        if (l2 == null) {
            cur.next = l1;
            return;
        }
        if (l1.val <= l2.val) {
            cur.next = l1;
            l1 = l1.next;
        } else {
            cur.next = l2;
            l2 = l2.next;
        }
        merge(cur.next, l1, l2);
    }
}
