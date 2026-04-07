import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int answer = 0;

        // 수정 1: 2차원 차분 배열 사용
        int[][] diff = new int[n + 1][m + 1];

        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];

            // 수정 2: 공격이면 음수, 회복이면 양수로 통일
            int value = (type == 1) ? -degree : degree;

            // 수정 3: 직사각형 전체를 직접 갱신하지 않고 꼭짓점 4곳만 표시
            diff[r1][c1] += value;
            if (c2 + 1 < m) diff[r1][c2 + 1] -= value;
            if (r2 + 1 < n) diff[r2 + 1][c1] -= value;
            if (r2 + 1 < n && c2 + 1 < m) diff[r2 + 1][c2 + 1] += value;
        }

        // 수정 4: 가로 누적합
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // 수정 5: 세로 누적합
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        // 수정 6: 최종 내구도 계산 후 살아남은 건물 개수 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + diff[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }//solution end
}//class end