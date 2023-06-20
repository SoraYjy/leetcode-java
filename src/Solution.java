/**
 * @author yujingyi
 * @date 2023/6/6
 */
public class Solution {

  public static class ListNode {
    private ListNode next;

    private int val;

    public ListNode(int val, ListNode next) {
      this.val = val;

      this.next = next;
    }

    public ListNode(int val) {
      this.val = val;
    }
  }

  public boolean findCycle(ListNode head) {
    if (head == null) {
      return false;
    }

    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode slow = dummy, fast = dummy.next;

    while (fast.next != null) {
      if (fast == slow) {
        return true;
      }

      fast = fast.next.next;
      slow = slow.next;
    }

    return false;
  }
}


