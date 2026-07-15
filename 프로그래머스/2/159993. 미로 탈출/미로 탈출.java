import java.util.*;

class Node{
    int x;
    int y;
    boolean check;
    int time;
    public Node(int x,int y,boolean check,int time){
        this.x = x;
        this.y = y;
        this.check = check;
        this.time = time;
    }
}

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] arr;
    static int sx,sy,ex,ey,n,m,answer;
    public int solution(String[] maps) {
        answer = -1;
        
        arr = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                arr[i][j] = maps[i].charAt(j);
            }
        }
        
        n = arr.length;
        m = arr[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }else if(arr[i][j] == 'E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        
        bfs();
        
        return answer;
    }//solution end
    
    private static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx,sy,false,0));
        boolean[][][] visited = new boolean[n][m][2];
        visited[sx][sy][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.x == ex && now.y == ey && now.check){
                answer = now.time;
                return;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny)) continue;
                if(arr[nx][ny] == 'X') continue;

                boolean nextCheck = false;
                int nextLever = 0;
                if(arr[nx][ny] == 'L' || now.check){
                    nextCheck = true;
                    nextLever = 1;
                }
                
                if(visited[nx][ny][nextLever])continue;
                visited[nx][ny][nextLever] = true;
                q.offer(new Node(nx,ny,nextCheck,now.time + 1));
            }
        }
        
        return;
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}//class end