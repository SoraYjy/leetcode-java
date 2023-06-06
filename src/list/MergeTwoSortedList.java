package list;

import list.model.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeTwoSortedList {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }

    if (list2 == null) {
      return list1;
    }

    ListNode head;
    if (list1.val >= list2.val) {
      head = list2;
      list2 = list2.next;
    } else {
      head = list1;
      list1 = list1.next;
    }
    ListNode res = head;
    while (list1 != null && list2 != null) {
      if (list1.val >= list2.val) {
        head.next = list2;
        list2 = list2.next;
      } else {
        head.next = list1;
        list1 = list1.next;
      }
    }

    if (list1 == null) {
      head.next = list2;
    }

    if (list2 == null) {
      head.next = list1;
    }

    return res;
  }

  public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1), p = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val >= list2.val) {
        p.next = list2;
        list2 = list2.next;
      } else {
        p.next = list1;
        list1 = list1.next;
      }
      p = p.next;
    }

    if (list1 == null) {
      p.next = list2;
    }

    if (list2 == null) {
      p.next = list1;
    }

    return dummy.next;
  }



}
