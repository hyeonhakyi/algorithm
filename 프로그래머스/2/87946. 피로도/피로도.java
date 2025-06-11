import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        
        visited = new boolean[dungeons.length];
        
        dfs(dungeons,k,0);
        
        return answer;
    }
    
    static void dfs(int[][] dungeons,int k,int count){
        answer = Math.max(answer,count);
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i]){
                if(dungeons[i][0] <= k){
                    visited[i] = true;
                    dfs(dungeons,k - dungeons[i][1],count+1);
                    visited[i] = false;
                }
            }
        }
    }//dfs end
}