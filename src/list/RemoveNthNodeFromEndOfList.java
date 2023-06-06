package list;

import list.model.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 */
public class RemoveNthNodeFromEndOfList {
    private int revSeq = 0;

    /**
     * 带公共变量的递归
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode next = removeNthFromEnd(head.next, n);
        ++revSeq;
        if (revSeq == n) {
            head.next = null;
            return next;
        } else {
            head.next = next;
            return head;
        }
    }

    /**
     * 快慢指针遍历
     * 转自：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
     * 作者：LeetCode
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndFastAndSlowPointer(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        System.out.println(listNode1);
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        ListNode newHead = solution.removeNthFromEnd(listNode1, 2);
        System.out.println(newHead);

    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy, slow = dummy;

        for (int i = 0; i < n; ++i) {
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

}
