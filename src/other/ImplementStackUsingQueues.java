package other;

import java.util.LinkedList;

/**
 * 225. Implement Stack using Queues
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class ImplementStackUsingQueues {
    private LinkedList<Integer>[] queues;

    private int from = 0;

    private int head;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        queues = new LinkedList[2];
        queues[0] = new LinkedList<>();
        queues[1] = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queues[from].offer(x);
        head = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int cur = queues[from].poll();
        int to = (from + 1) % 2;
        while (!empty()) {
            head = cur;
            queues[to].offer(cur);
            cur = queues[from].poll();
        }
        from = to;
        return cur;
    }

    /** Get the top element. */
    public int top() {
        return head;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queues[from].isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }
}
