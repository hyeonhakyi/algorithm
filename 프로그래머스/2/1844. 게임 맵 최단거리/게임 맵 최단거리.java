import java.util.*;

class Node{
    int x;
    int y;
    int cnt;
    public Node(int x,int y,int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

class Solution {
    static int n,m,answer;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        answer = -1;
        n = maps.length;
        m = maps[0].length;
        
        bfs(maps);
        
        return answer;
    }//solution end
    private static void bfs(int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,1));
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            
            if(nowX == n - 1 && nowY == m - 1){
                answer = now.cnt;
                return;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx][ny] == 0) continue;
                
                q.offer(new Node(nx,ny,now.cnt + 1));
                visited[nx][ny] = true;
            }
        }
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}//class end