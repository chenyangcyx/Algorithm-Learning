package QuestionBank.No101_200;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;

public class No146LRUCache {
    LinkedList<Pair<Integer, Integer>> list = new LinkedList<>();
    HashMap<Integer, Integer> locate = new HashMap<>();
    int count = 0;

    public No146LRUCache(int capacity) {
        this.count = capacity;
    }

    public int get(int key) {
        if (locate.containsKey(key)) {
            int index = locate.get(key);
            int value = list.get(index).getValue();
            list.addLast(list.remove(index));
            // 更新locate的映射表
            locate.clear();
            for (int i = 0; i < list.size(); i++) locate.put(list.get(i).getKey(), i);
            return value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (locate.containsKey(key)) {
            int index = locate.get(key);
            list.remove(index);
            list.addLast(new Pair<>(key, value));
            // 更新locate的映射表
            locate.clear();
            for (int i = 0; i < list.size(); i++) locate.put(list.get(i).getKey(), i);
        } else {
            // 容量不足，删除多余的部分
            if (list.size() >= count) {
                list.pollFirst().getKey();
                list.addLast(new Pair<>(key, value));
                // 更新locate的映射表
                locate.clear();
                for (int i = 0; i < list.size(); i++) locate.put(list.get(i).getKey(), i);
            }
            // 容量剩余，可以直接添加
            else {
                list.addLast(new Pair<>(key, value));
                locate.put(key, list.size() - 1);
                // 更新locate的映射表
                locate.clear();
                for (int i = 0; i < list.size(); i++) locate.put(list.get(i).getKey(), i);
            }
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
*/