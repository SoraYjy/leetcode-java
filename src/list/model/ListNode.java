package list.model;

/**
 * Created by yujingyi on 2020-04-22.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
