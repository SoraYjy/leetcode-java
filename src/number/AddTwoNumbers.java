package number;

import list.model.ListNode;

/**
 * 2. Add Two Numbers
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 为防止一些空判断，这次用一个 dummy head
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        dummy1.next = l1;
        dummy2.next = l2;
        add(dummy1, dummy2, 0);
        return dummy1.next;
    }

    /**
     * 迭代进行链表节点的相加和拼接
     * @param l1
     * @param l2
     * @param carry
     */
    private void add(ListNode l1, ListNode l2, int carry) {
        if (l1.next == null && l2.next == null) {
            l1.next = carry > 0 ? new ListNode(carry) : null;
            return;
        } else if (l1.next == null) {
            if (carry > 0) {
                // mock node
                l1.next = new ListNode(1);
                carry = 0;
            } else {
                l1.next = l2.next;
                return;
            }
        } else if (l2.next == null) {
            if (carry > 0) {
                // mock node
                l2.next = new ListNode(1);
                carry = 0;
            } else {
                l1.next.val += carry;
                return;
            }
        }

        int newVal = l1.next.val + l2.next.val + carry;
        l1.next.val = newVal > 9 ? newVal - 10 : newVal;
        add(l1.next, l2.next, newVal > 9 ? 1 : 0);
    }
}
