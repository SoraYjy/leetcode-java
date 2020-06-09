package other;

import java.util.LinkedList;

/**
 * 232. Implement Queue using Stacks
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * Best solution:
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/solution/yong-zhan-shi-xian-dui-lie-by-leetcode/
 */
public class ImplementQueueUsingStacks {
    private LinkedList<Integer>[] stacks;
    private int from = 0;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stacks = new LinkedList[2];
        stacks[0] = new LinkedList<>();
        stacks[1] = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        int to = (from + 1) % 2;
        int size = stacks[from].size();
        for (int i = 0; i < size; ++i) {
            stacks[to].add(stacks[from].removeLast());
        }
        stacks[from].push(x);
        for (int i = 0; i < size; ++i) {
            stacks[from].add(stacks[to].removeLast());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stacks[from].removeLast();
    }

    /** Get the front element. */
    public int peek() {
        return stacks[from].getLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stacks[from].size() > 0;
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks implementQueueUsingStacks = new ImplementQueueUsingStacks();
        implementQueueUsingStacks.push(1);
        implementQueueUsingStacks.push(2);
        System.out.println(implementQueueUsingStacks.peek());
        System.out.println(implementQueueUsingStacks.pop());
    }
}
