import QuestionBank.No815BusRoutes;

public class Main {
    public static void main(String[] args) {
        No815BusRoutes br=new No815BusRoutes();
        int [][]nums1=new int[][]{{1,2,7},{3,6,7}};
        int [][]nums2=new int[][]{{1,7},{3,5}};
        System.out.println(br.numBusesToDestination(nums1,1,6));
    }
}
