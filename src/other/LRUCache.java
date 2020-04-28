package other;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, DListNode> cacheMap;
    private DListNode head;
    private DListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        // set dummy
        head = new DListNode(-1, -1);
        tail = new DListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DListNode curNode = cacheMap.get(key);
        if (curNode != null) {
            moveToHead(curNode);
            return curNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DListNode curNode = cacheMap.get(key);
        if (curNode != null) {
            curNode.val = value;
            moveToHead(curNode);
            return;
        }
        DListNode dListNode = new DListNode(key, value);
        moveToHead(dListNode);
        if (cacheMap.size() >= capacity) {
            removeTail();
        }
        cacheMap.put(key, dListNode);
    }

    private void addToHead(DListNode dListNode) {
//        DListNode tmpNode = head.next;
//        tmpNode.pre = dListNode;
//        head.next = dListNode;
//        dListNode.pre = head;
//        dListNode.next = tmpNode;

        dListNode.pre = head;
        dListNode.next = head.next;
        head.next.pre = dListNode;
        head.next = dListNode;
    }

    private void removeTail() {
        DListNode tmpNode = tail.pre;
        tmpNode.pre.next = tail;
        tail.pre = tmpNode.pre;
        cacheMap.remove(tmpNode.key);
    }

    private void addToTail(DListNode dListNode) {

    }

    private void moveToHead(DListNode dListNode) {
        if (dListNode.pre != null) {
            dListNode.pre.next = dListNode.next;
        }
        if (dListNode.next != null) {
            dListNode.next.pre = dListNode.pre;
        }
        addToHead(dListNode);
    }

    private void moveToTail(DListNode dListNode) {

    }

    public class DListNode {
        int key;
        int val;
        DListNode pre;
        DListNode next;

        DListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));// returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4

        LRUCache cache = new LRUCache( 1 /* capacity */ );
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));


    }
}
