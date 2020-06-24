package list;

import list.model.ListNode;

/**
 * 142. Linked List Cycle II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycle {
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        ListNode newSlow = head;
        while (newSlow != slow) {
            slow = slow.next;
            newSlow = newSlow.next;
        }
        return slow;
    }
}
