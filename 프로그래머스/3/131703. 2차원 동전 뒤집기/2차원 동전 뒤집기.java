class Solution {
    static int n,m;
    static int[][] be;
    static int[][] t;
    static int ans = Integer.MAX_VALUE;
    public int solution(int[][] beginning, int[][] target) {
        n = beginning.length;
        m = beginning[0].length;
        
        be = new int[n][m];
        for(int i = 0; i < n; i++){
            be[i] = beginning[i].clone();
        }
        
        t = target;
        
        dfs(0,0);
        
        if(ans == Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        }
    }
    
    static void dfs(int r,int cnt){
        if(r == n){
            boolean check = true;
            for(int i = 0; i < m; i++){
                int result = col(i);
                if(result == -1){
                    check = false;
                    break;
                }
                cnt += result;
            }
            
            if(check){
                ans = Math.min(ans,cnt);
            }
            return;
        }
        
        row(r);
        dfs(r + 1, cnt + 1);
        row(r);
        
        dfs(r + 1, cnt);
    }//dfs end
    
    static void row(int r){
        for(int i = 0; i < m; i++){
            be[r][i] = (be[r][i] + 1) % 2;
        }
    }
    
    static int col(int c){
        int result = 0;
        for(int i = 0; i < n; i++){
            if(be[i][c] == t[i][c]){
                result++;
            }
        }
        if(result == n) return 0;
        else if(result == 0) return 1;
        else return -1;
    }//col end
}