import QuestionBank.No74Searcha2DMatrix;

public class Main {
    public static void main(String[] args) {
        int [][]matrix1=new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int [][]matrix2=new int[][]{{1,1}};
        int [][]matrix3=new int[][]{{1,3}};
        No74Searcha2DMatrix sm=new No74Searcha2DMatrix();
        System.out.println(sm.searchMatrix(matrix1,13));
        System.out.println(sm.searchMatrix(matrix2,0));
        System.out.println(sm.searchMatrix(matrix3,3));
    }
}
