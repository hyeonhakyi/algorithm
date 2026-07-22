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
    static char[][] arr;
    static int n,m,answer,sx,sy,ex,ey;
    public int solution(String[] board) {
        answer = 0;
        n = board.length;
        m = board[0].length(); 
        arr = new char[n][m];
        
        for(int i = 0; i < n; i++){
            arr[i] = board[i].toCharArray();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'R'){
                    sx = i;
                    sy = j;
                }else if(arr[i][j] == 'G'){
                    ex = i;
                    ey = j;
                }
            }
        }
        
        bfs();
        
        if(answer == 0){
            return -1;
        }else{
            return answer;
        }
    }//solution end
    
    private static void bfs(){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.offer(new Node(sx,sy,0));
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.x == ex && now.y == ey){
                answer = now.cnt;
                return;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x;
                int ny = now.y;
                
                while(true){
                    int nextx = nx + dx[d];
                    int nexty = ny + dy[d];
                    
                    if(!check(nextx,nexty)) break;
                    if(arr[nextx][nexty] == 'D') break;
                    
                    nx = nextx;
                    ny = nexty;
                }
                
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.offer(new Node(nx,ny,now.cnt + 1));
            }
        }
        return;
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}//class end