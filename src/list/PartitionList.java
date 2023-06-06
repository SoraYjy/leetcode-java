package list;

import list.model.ListNode;

/**
 * @author yujingyi
 * @date 2023/6/1
 */
public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode dummy = new ListNode(-1), small = dummy, big = dummy, p = head;
    ListNode smallHead = null;
    ListNode bigHead = null;
    while (p != null) {
      if (p.val < x) {
        small.next = p;
        if (smallHead == null) {
          smallHead = p;
        }
        small = small.next;
      } else {
        big.next = p;
        if (bigHead == null) {
          bigHead = p;
        }
        big = big.next;
      }
      p = p.next;
    }

    if (smallHead != null) {
      small.next = bigHead;
      big.next = null;
    } else {
      smallHead = head;
    }

    return smallHead;
  }

  public ListNode partition1(ListNode head, int x) {
    ListNode dummy1 = new ListNode(-1), small = dummy1;
    ListNode dummy2 = new ListNode(-1), big = dummy2;
    while (head != null) {
      if (head.val < x) {
        small.next = head;
        small = small.next;
      } else {
        big.next = head;
        big = big.next;
      }
      head = head.next;
    }

    small.next = dummy2.next;
    big.next = null;

    return dummy1.next;
  }
}
