package QuestionBank.No701_800;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class No705DesignHashSet {
    private ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
    private final int bucket_size = 20;

    /**
     * Initialize your data structure here.
     */
    public No705DesignHashSet() {
        // 构造函数
        // 默认的桶的数量为20个
        for (int i = 1; i <= bucket_size; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        // 计算插入值的hash值
        int hash = key % bucket_size;
        // 查看该桶中是否包含该元素
        if (!contains(key)) buckets.get(hash).addFirst(key);
    }

    public void remove(int key) {
        // 计算插入值的hash值
        int hash = key % bucket_size;
        // 查看该桶中是否包含该元素
        if (contains(key)) buckets.get(hash).remove((Integer) key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = key % bucket_size;
        LinkedList<Integer> bucket = buckets.get(hash);
        return bucket.contains(key);
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

    // LeetCode 参考代码
//    private static final int BASE = 769;
//    private LinkedList[] data;
//
//    /** Initialize your data structure here. */
//    public MyHashSet() {
//        data = new LinkedList[BASE];
//        for (int i = 0; i < BASE; ++i) {
//            data[i] = new LinkedList<Integer>();
//        }
//    }
//
//    public void add(int key) {
//        int h = hash(key);
//        Iterator<Integer> iterator = data[h].iterator();
//        while (iterator.hasNext()) {
//            Integer element = iterator.next();
//            if (element == key) {
//                return;
//            }
//        }
//        data[h].offerLast(key);
//    }
//
//    public void remove(int key) {
//        int h = hash(key);
//        Iterator<Integer> iterator = data[h].iterator();
//        while (iterator.hasNext()) {
//            Integer element = iterator.next();
//            if (element == key) {
//                data[h].remove(element);
//                return;
//            }
//        }
//    }
//
//    /** Returns true if this set contains the specified element */
//    public boolean contains(int key) {
//        int h = hash(key);
//        Iterator<Integer> iterator = data[h].iterator();
//        while (iterator.hasNext()) {
//            Integer element = iterator.next();
//            if (element == key) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static int hash(int key) {
//        return key % BASE;
//    }
}
