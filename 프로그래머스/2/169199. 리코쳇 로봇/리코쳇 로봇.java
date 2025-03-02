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
    static char[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m,sx,sy;
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        arr = new char[n][m];
        
        for(int i = 0; i < n; i++){
            arr[i] = board[i].toCharArray();
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'R'){
                    sx = i;
                    sy = j;
                }
            }
        }
        answer = bfs();
        
        return answer;
    }//solution end
    
    public static int bfs(){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.offer(new Node(sx,sy,0));
        visited[sx][sy] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(arr[now.x][now.y] == 'G'){
                return now.cnt;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x;
                int ny = now.y;
                
                while(true){
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];
                    
                    if(!check(tx,ty)) break;
                    if(arr[tx][ty] == 'D') break;
                    
                    nx = tx;
                    ny = ty;
                }
                
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx,ny,now.cnt + 1));   
                }
            }
        }
        return -1;
    }//bfs end
    
    public static boolean check(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}