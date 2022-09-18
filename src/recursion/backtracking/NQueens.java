package recursion.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    private final int N;

    public NQueens(int N) {
        this.N = N;
    }

    public List<List<String>> nQueens() {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.';
            }
        }
        int[] leftDir = new int[N];
        int[] upperDiag = new int[2 * N - 1];
        int[] lowerDiag = new int[2 * N - 1];
        solve(0, result, board, leftDir, upperDiag, lowerDiag);
        return result;
    }

    public void solve(int col, List<List<String>> result, char[][] board, int[] leftDir, int[] upperDiag,
                      int[] lowerDiag) {
        if (col == N) {
            result.add(construct(board));
        }
        for (int row = 0; row < board.length; row++) {
            if (leftDir[row] == 0 && lowerDiag[row + col] == 0 &&
                    upperDiag[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftDir[row] = 1;
                lowerDiag[row + col] = 1;
                upperDiag[board.length - 1 + col - row] = 1;
                solve(col + 1, result, board, leftDir, upperDiag, lowerDiag);
                board[row][col] = '.';
                leftDir[row] = 0;
                lowerDiag[row + col] = 0;
                upperDiag[board.length - 1 + col - row] = 0;
            }
        }
    }

    public List<String> construct(char[][] board) {
        List<String> result = new LinkedList<>();
        for (char[] i : board) {
            String s = new String(i);
            result.add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 4, indx = 1;

        NQueens nQueens = new NQueens(N);
        List<List<String>> result = nQueens.nQueens();

        if (!result.isEmpty()) {
            for (List<String> li : result) {
                System.out.println("Arrangement " + indx);
                for (String st : li) {
                    System.out.println(st);
                }
                System.out.println();
                indx++;
            }
        }
    }
}