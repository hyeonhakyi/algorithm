import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] check = new int[n+1][n+1];
        
        for(int[] r : results){
            int win = r[0];
            int lose = r[1];
            check[win][lose] = 1;
            check[lose][win] = -1;
        }
        
        
        for(int b = 1; b <= n; b++){
            for(int a = 1; a <= n; a++){
                for(int c = 1; c <= n; c++){
                    if(check[a][b] == 1 && check[b][c] == 1){
                        check[a][c] = 1;
                        check[c][a] = -1;
                    }else if(check[a][b] == -1 && check[b][c] == -1){
                        check[a][c] = -1;
                        check[c][a] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(check[i][j] != 0) cnt++;
            }
            if(cnt == n - 1) answer++;
        }
        
        return answer;
    }
}