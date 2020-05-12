package list;

import list.model.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * 快慢指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = new ListNode(-1);
        ListNode dummyB = new ListNode(-1);
        dummyA.next = headA;
        dummyB.next = headB;

        ListNode p1 = dummyA, p2 = dummyB;
        ListNode longer = p1, shorter = p2;
        int delta = 0;
        while (p1.next != null || p2.next != null) {
            if (p1.next == null) {
                shorter = dummyA;
                longer = dummyB;
                ++delta;
                p2 = p2.next;
            } else if (p2.next == null) {
                shorter = dummyB;
                longer = dummyA;
                ++delta;
                p1 = p1.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        ListNode intersectionNode = null;
        for (int i = 0; i < delta; ++i) {
            longer = longer.next;
        }

        while (longer.next != null || shorter.next != null) {
            if (longer.next == shorter.next) {
                intersectionNode = longer.next;
                break;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return intersectionNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(8);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(0);
        ListNode l5 = new ListNode(1);
        ListNode headA = l1;
        ListNode headB = l4;
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l2;

        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode res = intersectionOfTwoLinkedLists.getIntersectionNode(headA, headB);
        System.out.println(res);
    }
}
