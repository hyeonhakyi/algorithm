import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(r - x) + Math.abs(c - y);
        if(dist > k || (dist - k) % 2 != 0) return "impossible" ;
                
        char[] moveChar = {'d','l','r','u'};
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};
        
        int cx = x;
        int cy = y;
        int remain = k;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++){
            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(nx < 1 || ny < 1 || nx > n || ny > m) continue;
                
                int need = Math.abs(r - nx) + Math.abs(c - ny);
                int left = remain - 1;
                if(left >= need && (left - need) % 2 == 0){
                    sb.append(moveChar[d]);
                    cx = nx;
                    cy = ny;
                    remain = left;
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}