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
    static int answer, n, m;
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        n = maps.length;
        m = maps[0].length;
        
        bfs(maps);
        
        if(answer == Integer.MAX_VALUE){
            return -1;
        }else{
            return answer;    
        }
    }
    
    static void bfs(int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,1));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if((nx == n - 1) && (ny == m - 1)){
                    answer = Math.min(answer,now.cnt + 1);
                    continue;
                }
                
                if(!check(nx,ny) || visited[nx][ny]){
                    continue;
                }
                
                if(maps[nx][ny] == 0){
                    continue;
                }
                
                q.offer(new Node(nx,ny,now.cnt+1));
                visited[nx][ny] = true;
            }
        }
    }//bfs end
    
    static boolean check(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}