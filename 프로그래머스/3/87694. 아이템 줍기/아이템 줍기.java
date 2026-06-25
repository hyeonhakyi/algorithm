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
    static int [][] arr = new int[102][102];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        for(int[] r : rectangle){
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for(int i = x1; i <= x2 ; i++){
                for(int j = y1; j <= y2; j++){
                    arr[i][j] = 1;
                }
            }
        }
        
        for(int[] r : rectangle){
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for(int i = x1 + 1; i < x2; i++){
                for(int j = y1 + 1; j < y2; j++){
                    arr[i][j] = 0;
                }
            }
        }
        
        answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        
        return answer / 2;
    }//solution end
    
    private static int bfs(int sx,int sy,int ex,int ey){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        q.offer(new Node(sx,sy,1));
        visited[sx][sy] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.x == ex && now.y == ey){
                return now.cnt;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 0) continue;
                q.offer(new Node(nx,ny,now.cnt + 1));
                visited[nx][ny] = true;
            }
        }
        
        return - 1;
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < 102 && y >= 0 && y < 102;
    }//check end
}//class end