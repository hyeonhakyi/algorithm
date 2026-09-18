import java.util.*;

class Node{
    int x;
    int y;
    int dist;
    public Node(int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    static int[][] arr = new int[102][102];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        for(int[] rec : rectangle){
            int x = rec[0] * 2;
            int y = rec[1] * 2;
            int x1 = rec[2] * 2;
            int y1 = rec[3] * 2;
            
            for(int i = x; i <= x1; i++){
                for(int j = y; j <= y1; j++){
                    arr[i][j] = 1;
                }
            }
        }
        
        for(int[] rec : rectangle){
            int x = rec[0] * 2;
            int y = rec[1] * 2;
            int x1 = rec[2] * 2;
            int y1 = rec[3] * 2;
            
            for(int i = x + 1; i < x1; i++){
                for(int j = y + 1; j < y1; j++){
                    arr[i][j] = 0;
                }
            }
        }
        
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }//solution end
    
    private static int bfs(int sx,int sy,int ex,int ey){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        q.offer(new Node(sx,sy,0));
        visited[sx][sy] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.x == ex && now.y == ey){
                return now.dist + 1;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                q.offer(new Node(nx,ny,now.dist + 1));
            }
        }
        return 0;
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < 102 && y >= 0 && y < 102;
    }//check end
}//class end