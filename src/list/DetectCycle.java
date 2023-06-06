package list;

import list.model.ListNode;

/**
 * @author yujingyi
 * @date 2023/6/2
 */
public class DetectCycle {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (slow == fast) {
        fast = head;
        while (fast != slow) {
          fast = fast.next;
          slow = slow.next;
        }
        return fast;
      }
    }



    return null;
  }

}
