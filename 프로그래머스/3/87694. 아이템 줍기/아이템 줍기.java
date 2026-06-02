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
    static boolean[][] visited = new boolean[102][102];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        for(int[] r : rectangle){
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for(int x = x1; x <= x2; x++){
                for(int y = y1; y <= y2; y++){
                    arr[x][y] = 1;
                }
            }
        }
        
        for(int[] r : rectangle){
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for(int x = x1 + 1; x < x2; x++){
                for(int y = y1 + 1; y < y2; y++){
                    arr[x][y] = 0;
                }
            }
        }
        
        int startX = characterX * 2;
        int startY = characterY * 2;
        int endX = itemX * 2;
        int endY = itemY * 2;
        
        return bfs(startX,startY,endX,endY) / 2;
    }//solution end
    
    private static int bfs(int startX,int startY,int endX,int endY){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX,startY,1));
        visited[startX][startY] = true;
       
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.x == endX && now.y == endY){
                return now.dist;
            }
                
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 0) continue;
                q.offer(new Node(nx,ny,now.dist + 1));
                visited[nx][ny] = true;
            }
        }
        return 0;
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < 102 && y >= 0 && y < 102;
    }//check end
}//class end