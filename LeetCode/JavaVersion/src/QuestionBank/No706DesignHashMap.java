package QuestionBank;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

public class No706DesignHashMap {
    private final ArrayList<LinkedList<Pair<Integer, Integer>>> buckets = new ArrayList<>();
    private final int bucket_size = 20;

    /**
     * Initialize your data structure here.
     */
    public No706DesignHashMap() {
        for (int i = 1; i <= bucket_size; i++) buckets.add(new LinkedList<>());
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        if (ifContain(key) == -1)
            buckets.get(getHashNum(key)).addFirst(new Pair<>(key, value));
        else {
            remove(key);
            buckets.get(getHashNum(key)).addFirst(new Pair<>(key, value));
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = ifContain(key);
        if (index != -1) return buckets.get(getHashNum(key)).get(index).getValue();
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = ifContain(key);
        if (index != -1) buckets.get(getHashNum(key)).remove(index);
    }

    private int getHashNum(int key) {
        return key >= 0 ? key % bucket_size : (-key) % bucket_size;
    }

    private int ifContain(int key) {
        LinkedList<Pair<Integer, Integer>> bu = buckets.get(getHashNum(key));
        for (int i = 0; i < bu.size(); i++) {
            if (bu.get(i).getKey() == key) return i;
        }
        return -1;
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */

    // LeetCode 参考代码
//    private class Pair {
//        private int key;
//        private int value;
//
//        public Pair(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public int getKey() {
//            return key;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//    }
//
//    private static final int BASE = 769;
//    private LinkedList[] data;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public MyHashMap() {
//        data = new LinkedList[BASE];
//        for (int i = 0; i < BASE; ++i) {
//            data[i] = new LinkedList<Pair>();
//        }
//    }
//
//    /**
//     * value will always be non-negative.
//     */
//    public void put(int key, int value) {
//        int h = hash(key);
//        Iterator<Pair> iterator = data[h].iterator();
//        while (iterator.hasNext()) {
//            Pair pair = iterator.next();
//            if (pair.getKey() == key) {
//                pair.setValue(value);
//                return;
//            }
//        }
//        data[h].offerLast(new Pair(key, value));
//    }
//
//    /**
//     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
//     */
//    public int get(int key) {
//        int h = hash(key);
//        Iterator<Pair> iterator = data[h].iterator();
//        while (iterator.hasNext()) {
//            Pair pair = iterator.next();
//            if (pair.getKey() == key) {
//                return pair.value;
//            }
//        }
//        return -1;
//    }
//
//    /**
//     * Removes the mapping of the specified value key if this map contains a mapping for the key
//     */
//    public void remove(int key) {
//        int h = hash(key);
//        Iterator<Pair> iterator = data[h].iterator();
//        while (iterator.hasNext()) {
//            Pair pair = iterator.next();
//            if (pair.key == key) {
//                data[h].remove(pair);
//                return;
//            }
//        }
//    }
//
//    private static int hash(int key) {
//        return key % BASE;
//    }
}
