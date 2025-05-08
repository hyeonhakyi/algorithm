import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] check = new boolean[n+1][n+1];
        
        for(int[] result : results){
            check[result[0]][result[1]] = true;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(check[j][i] && check[i][k]){
                        check[j][k] = true;
                    }
                }
            }
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            count = 0;
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(check[i][j] || check[j][i]){
                    count++;
                }
            }
            if(count == n-1){
                answer++;
            }
        }
        
        
        return answer;
    }
}