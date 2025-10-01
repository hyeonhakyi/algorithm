import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        
        visited = new boolean[dungeons.length];
        
        dfs(dungeons,k,0);
        
        return answer;
    }
    
    public static void dfs(int[][] d,int k,int cnt){
        answer = Math.max(cnt,answer);
        
        for(int i = 0; i < d.length; i++){
            if(!visited[i]){
                if(d[i][0] <= k){
                    visited[i] = true;
                    dfs(d,k - d[i][1],cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }//dfs end
}