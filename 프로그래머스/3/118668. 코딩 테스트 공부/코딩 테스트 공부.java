import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        int targetAlp = 0;
        int targetCop = 0;
        
        for(int[] p : problems){
            targetAlp = Math.max(targetAlp,p[0]);
            targetCop = Math.max(targetCop,p[1]);
        }
        
        alp = Math.min(alp,targetAlp);
        cop = Math.min(cop,targetCop);
        
        int[][] dp = new int[targetAlp + 1][targetCop + 1];
        
        for(int[] row : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0;
        
        for(int a = alp; a <= targetAlp; a++){
            for(int c = cop; c <= targetCop; c++){
                if(dp[a][c] == Integer.MAX_VALUE){
                    continue;
                }
                
                if(a < targetAlp){
                    dp[a + 1][c] = Math.min(dp[a + 1][c],dp[a][c] + 1);
                }
                
                if(c < targetCop){
                    dp[a][c + 1] = Math.min(dp[a][c + 1],dp[a][c] + 1);
                }
                
                for(int[] p : problems){
                    if(a < p[0] || c < p[1]) continue;
                    
                    int na = Math.min(targetAlp, a + p[2]);
                    int nc = Math.min(targetCop, c + p[3]);
                    
                    dp[na][nc] = Math.min(dp[na][nc],dp[a][c] + p[4]);
                }
            }
        }
        
        
        return dp[targetAlp][targetCop];
    }//solution end
}//class end