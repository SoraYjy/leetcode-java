package list;

import list.model.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        delete(dummy);
        return dummy.next;
    }

    public void delete(ListNode head) {
        if (head.next == null || head.next.next == null) return;
        ListNode next = head.next;
        boolean needDelNext = false;
        while (next.next != null && next.val == next.next.val) {
            needDelNext = true;
            next.next = next.next.next;
        }
        if (needDelNext) {
            head.next = next.next;
            delete(head);
        } else {
            delete(head.next);
        }
    }
}
