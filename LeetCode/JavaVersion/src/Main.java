import QuestionBank.No56MergeIntervals;

public class Main {
    public static void main(String[] args) {
        int [][]nums=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        No56MergeIntervals mi=new No56MergeIntervals();
        int [][]result=mi.merge(nums);
        for(int []line:result){
            for(int num:line) System.out.print(num+" ");
            System.out.println();
        }
    }
}
