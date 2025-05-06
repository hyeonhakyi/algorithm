class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        int mod = 1_000_000_007;
        dp[0] = 1;
        
        for(int m : money){
            for(int i = m; i <= n; i++){
                dp[i] = (dp[i] + dp[i - m]) % mod;
            }
        }
        
        
        return dp[n];
    }
}