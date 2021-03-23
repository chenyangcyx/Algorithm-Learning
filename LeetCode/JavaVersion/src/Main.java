import QuestionBank.No146LRUCache;

public class Main {
    public static void main(String[] args) {
        No146LRUCache cc=new No146LRUCache(2);
        cc.put(1,1);
        cc.put(2,2);
        System.out.println(cc.get(1));
        cc.put(3,3);
        System.out.println(cc.get(2));
        cc.put(4,4);
        System.out.println(cc.get(1));
        System.out.println(cc.get(3));
        System.out.println(cc.get(4));
    }
}
