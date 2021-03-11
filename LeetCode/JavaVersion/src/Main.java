import CSNotes.DFS.No130SurroundedRegions;

public class Main {
    public static void main(String[] args) {
        char[][] board1 = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new No130SurroundedRegions().solve(board1);
        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1[i].length; j++)
                System.out.print(board1[i][j]);
            System.out.println();
        }

        char[][] board2 = new char[][]{{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}};
        new No130SurroundedRegions().solve(board2);
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2[i].length; j++)
                System.out.print(board2[i][j]);
            System.out.println();
        }
        
        char [][]board3=new char[][]{{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},{'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}};
        new No130SurroundedRegions().solve(board3);
        for (int i = 0; i < board3.length; i++) {
            for (int j = 0; j < board3[i].length; j++)
                System.out.print(board3[i][j]);
            System.out.println();
        }
    }
}
