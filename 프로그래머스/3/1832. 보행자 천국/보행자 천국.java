class Solution {
    static final int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];

        // 수정: 시작점은 한 번만 세어야 함
        dp[0][0][0] = 1;
        dp[0][0][1] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (cityMap[i][j] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                    continue;
                }

                // 위에서 아래로 내려와서 현재 칸에 도착하는 경우
                if (i > 0 && cityMap[i - 1][j] != 1) {
                    if (cityMap[i - 1][j] == 2) {
                        dp[i][j][0] = dp[i - 1][j][0];
                    } else {
                        dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                    }
                }

                // 왼쪽에서 오른쪽으로 와서 현재 칸에 도착하는 경우
                if (j > 0 && cityMap[i][j - 1] != 1) {
                    if (cityMap[i][j - 1] == 2) {
                        dp[i][j][1] = dp[i][j - 1][1];
                    } else {
                        dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                    }
                }
            }
        }

        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }
}