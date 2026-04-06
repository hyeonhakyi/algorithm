import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] dist = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++){
            Arrays.fill(dist[i],-1);   
        }
        
        for(int[] num : results){
            int a = num[0];
            int b = num[1];
            
            dist[a][b] = 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(dist[j][i] == 1 && dist[i][k] == 1){
                        dist[j][k] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            boolean check = true;
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(dist[i][j] == -1 && dist[j][i] == -1){
                    check = false;
                    continue;
                }
            }
            if(check){
                answer++;
            }
        }
        
        return answer;
    }//solution end
}//class end