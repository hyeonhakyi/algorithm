import java.util.*;

class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] dirChar = {'d', 'l', 'r', 'u'};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = Math.abs(x - r) + Math.abs(y - c);
        
        if(distance > k || (k - distance) % 2 != 0){
            return "impossible";
        }
        
        StringBuilder answer = new StringBuilder();
        int nowX = x;
        int nowY = y;
        
        for(int i = 0; i < k; i++){
            for(int d = 0; d < 4; d++){
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                if(nx >= 1 && nx <= n && ny >= 1 && ny <= m){
                    int remainDist = Math.abs(nx - r) + Math.abs(ny - c);
                    
                    if(remainDist <= (k - 1 - i)){
                        nowX = nx;
                        nowY = ny;
                        answer.append(dirChar[d]);
                        break;
                    }
                }
            }
        }
        
        return answer.toString();
    }//solution end
}//class end