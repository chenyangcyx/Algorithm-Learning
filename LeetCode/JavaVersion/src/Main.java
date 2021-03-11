import CSNotes.DFS.No547NumberofProvinces;

public class Main {
    public static void main(String[] args) {
        int [][]map1=new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int [][]map2=new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(new No547NumberofProvinces().findCircleNum(map2));
    }
}
