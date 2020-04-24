package list;

import list.model.ListNode;

/**
 * 206.reverse linked list
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 */
public class ReverseList {
    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = head;
            head = next;
            next = tmp;
        }

        return head;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseUnit(null, head);
    }

    public ListNode reverseUnit(ListNode pre, ListNode head) {
        ListNode tmp = head.next;
        head.next = pre;
        return tmp != null ? reverseUnit(head, tmp) : head;
    }

    /**
     * 精简版递归
     * @param head
     * @return
     */
    public ListNode reverseListRecurOptimized(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseListRecurOptimized(head.next);
        head.next.next = head;
        head.next = null;
        return node;
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
        ReverseList reverseList = new ReverseList();
        ListNode newHead = reverseList.reverseListRecurOptimized(listNode1);
        System.out.println(newHead);

    }
}
