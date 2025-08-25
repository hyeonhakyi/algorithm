import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] acc = new int[n+1][m+1];
        
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            int d = (type == 1 ? -degree : degree);
            
            acc[r1][c1] += d;
            acc[r1][c2+1] -= d;
            acc[r2+1][c1] -= d;
            acc[r2+1][c2+1] += d;
        }
        
        for (int i = 0; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                acc[i][j] += acc[i][j-1];
            }
        }

        // 열 방향 누적
        for (int j = 0; j < m+1; j++) {
            for (int i = 1; i < n+1; i++) {
                acc[i][j] += acc[i-1][j];
            }
        }
        
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + acc[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}