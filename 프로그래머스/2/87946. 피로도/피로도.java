import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        
        dfs(k,dungeons,0);
        
        return answer;
    }//solution end
    
    private static void dfs(int k,int[][] dungeons,int count){
        answer = Math.max(answer,count);
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]){
                continue;
            }
            
            if(dungeons[i][0] > k){
                continue;
            }
            
            visited[i] = true;
            dfs(k - dungeons[i][1],dungeons,count + 1);
            visited[i] = false;
        }
    }//dfs end
}//class end