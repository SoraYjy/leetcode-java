package list;

import list.model.ListNode;

/**
 * @author yujingyi
 * @date 2023/6/2
 */
public class GetIntersectionNode {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode p1 = headA, p2 = headB;
    while (headA != headB) {
      if (p1 == null) {
        p1 = headB;
      } else {
        p1 = p1.next;
      }

      if (p2 == null) {
        p2 = headA;
      } else {
        p2 = p2.next;
      }
    }

    return headA;

  }

}
