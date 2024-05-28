import java.util.*;

class Solution {
    public static class Node{
        int x;
        int y;
        int count;
        public Node(int x,int y,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static boolean[][] visited;
    public static int n,m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        // if(maps[n-2][m-1] == 0 && maps[n-1][m-2] == 0){
        //     return -1;
        // }else{
            int answer = bfs(maps);
        
            return answer;      
        // }   
    }
    
    public static int bfs(int[][] map){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0,0,0));
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            Node now = que.poll();
            
            if(now.x == n-1 && now.y == m-1){
                return now.count+1;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny))continue;
                if(visited[nx][ny])continue;
                if(map[nx][ny] == 0)continue;
                visited[nx][ny] = true;
                que.offer(new Node(nx,ny,now.count+1));
            }
        }
        return -1;
    }//bfs end
    
    public static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}