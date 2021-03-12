import CSNotes.Backtracking.No79WordSearch;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new No79WordSearch().exist(board, "ABCCED"));
        System.out.println(new No79WordSearch().exist(board, "SEE"));
        System.out.println(new No79WordSearch().exist(board, "ABCB"));
    }
}
