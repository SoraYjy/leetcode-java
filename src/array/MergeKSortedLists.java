package array;

import list.model.ListNode;

import java.util.List;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    /**
     * O(n2)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        merge(dummy, lists);
        return dummy.next;
    }

    private void merge(ListNode cur, ListNode[] lists) {
        int minPos = -1, min = -1;
        for (int i = 0; i < lists.length; ++i) {
            ListNode node = lists[i];
            if (node != null) {
                if (minPos == -1) {
                    min = node.val;
                    minPos = i;
                } else if (node.val < min) {
                    minPos = i;
                    min = node.val;
                }
            }
        }
        if (minPos > -1) {
            cur.next = lists[minPos];
            lists[minPos] = lists[minPos].next;
            merge(cur.next, lists);
        }
    }


    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 用归并优化
     * @param lists
     * @return
     */
    public ListNode mergeKListsOptimized(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        mergeTwo(dummy, l1, l2);
        return dummy.next;
    }

    private void mergeTwo(ListNode cur, ListNode l1, ListNode l2) {
        if (l1 == null) {
            cur.next = l2;
            return;
        }
        if (l2 == null) {
            cur.next = l1;
            return;
        }
        if (l1.val <= l2.val) {
            cur.next = l1;
            l1 = l1.next;
        } else {
            cur.next = l2;
            l2 = l2.next;
        }
        mergeTwo(cur.next, l1, l2);
    }
}
