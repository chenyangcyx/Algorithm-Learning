import QuestionBank.No101_200.No122BestTimetoBuyandSellStockII;

public class Main {
    public static void main(String[] args) {
        int []nums1=new int[]{7,1,5,3,6,4};
        int []nums2=new int[]{1,2,3,4,5};
        int []nums3=new int[]{7,6,4,3,1};
        No122BestTimetoBuyandSellStockII btbss=new No122BestTimetoBuyandSellStockII();
        System.out.println(btbss.maxProfit(nums1));
        System.out.println(btbss.maxProfit(nums2));
        System.out.println(btbss.maxProfit(nums3));
    }
}
