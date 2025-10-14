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
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        
        answer = bfs(maps);
        
        return answer;
    }
    
    public static int bfs(int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,1));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if((now.x == n - 1) && (now.y == m - 1)){
                return now.cnt;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny)) continue;
                if(maps[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;
                
                q.offer(new Node(nx,ny,now.cnt + 1));
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
    
    static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}