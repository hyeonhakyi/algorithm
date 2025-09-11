import java.util.*;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        
        dp[0][0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(cityMap[i][j] == 1){
                    dp[i][j] = 0;
                    right[i][j] = 0;
                    down[i][j] = 0;
                    continue;
                }
                
                if(i == 0 && j == 0) continue;
                
                if(j > 0){
                    if(cityMap[i][j - 1] == 2){
                        right[i][j] = right[i][j -1];
                    }else{
                        right[i][j] = dp[i][j - 1];
                    }
                    right[i][j] %= MOD;
                }
                
                if(i > 0){
                    if(cityMap[i - 1][j] == 2){
                        down[i][j] = down[i - 1][j];
                    }else{
                        down[i][j] = dp[i - 1][j];
                    }
                    down[i][j] %= MOD;
                }
                
                dp[i][j] = (right[i][j] + down[i][j]) % MOD;
            }
        }
        
        return dp[m - 1][n - 1];
    }
}