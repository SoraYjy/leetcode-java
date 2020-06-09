package list;

import list.model.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * Iteration
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            head.next = head.next.next;
            deleteDuplicates(head);
        } else {
            deleteDuplicates(head.next);
        }
        return head;
    }
}
