import QuestionBank.No101_200.No121BestTimetoBuyandSellStock;

public class Main {
    public static void main(String[] args) {
        int []nums1=new int[]{7,1,5,3,6,4};
        int []nums2=new int[]{7,6,4,3,1};
        No121BestTimetoBuyandSellStock btbss=new No121BestTimetoBuyandSellStock();
        System.out.println(btbss.maxProfit(nums1));
        System.out.println(btbss.maxProfit(nums2));
    }
}
