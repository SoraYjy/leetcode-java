package list;

import java.util.Comparator;
import java.util.PriorityQueue;
import list.model.ListNode;

/**
 * @author yujingyi
 * @date 2023/6/1
 */
public class MergeKList {

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode(-1), p = dummy;
    ListNode res = null;

    for (ListNode l : lists) {
      res = merge(res, l);
    }

    return res;
  }

  public ListNode merge(ListNode res, ListNode l) {
    ListNode dummy = new ListNode(-1), p = dummy;

    while (res != null && l != null) {
      if (res.val > l.val) {
        p.next = l;
        l = l.next;
      } else {
        p.next = res;
        res = res.next;
      }
      p = p.next;
    }

    if (res != null) {
      p.next = res;
    }

    if (l != null) {
      p.next = l;
    }

    return dummy.next;
  }


  /** pirority **/
  public ListNode mergeKLists2(ListNode[] lists) {
    ListNode dummy = new ListNode(-1), p = dummy;

    PriorityQueue<ListNode> queue = new PriorityQueue<>(
        lists.length, new ListNodesComparator());

    for (int i = 0; i < lists.length; ++i) {
      queue.offer(lists[i]);
    }

    while (!queue.isEmpty()) {
      ListNode min = queue.poll();
      p.next = min;
      if (min.next != null) {
        queue.offer(min.next);
      }
      p = p.next;
    }

    return dummy.next;
  }

  public class ListNodesComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode l1, ListNode l2) {
      return l1.val - l2.val;
    }
  }


}
