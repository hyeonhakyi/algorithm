import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int max = 0;

        // 첫 행 확인
        for (int j = 0; j < m; j++) {
            max = Math.max(max, board[0][j]);
        }

        // 첫 열 확인
        for (int i = 0; i < n; i++) {
            max = Math.max(max, board[i][0]);
        }

        // (1, 1)부터 확인
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                // 현재 칸이 1일 때만 정사각형을 만들 수 있음
                if (board[i][j] == 1) {

                    board[i][j] =
                        Math.min(
                            Math.min(board[i - 1][j], board[i][j - 1]),
                            board[i - 1][j - 1]
                        ) + 1;

                    max = Math.max(max, board[i][j]);
                }
            }
        }

        return max * max;
    }
}