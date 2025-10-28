import java.util.*;

class Node{
    int x;
    int y;
    boolean check;
    int cnt;
    public Node(int x,int y,boolean check,int cnt){
        this.x = x;
        this.y = y;
        this.check = check;
        this.cnt = cnt;
    }
}

class Solution {
    static int n,m,sx,sy,lx,ly,ex,ey;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] arr;
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        arr = new char[n][m];
        
        for(int i = 0; i < maps.length; i++){
            arr[i] = maps[i].toCharArray();
            for(int j = 0; j < maps[i].length(); j++){
                if(arr[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }else if(arr[i][j] == 'L'){
                    lx = i;
                    ly = j;
                }else if(arr[i][j] == 'E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        
        answer = bfs();
        
        return answer;
    }
    
    public static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx,sy,false,0));
        boolean[][][] visited = new boolean[n][m][2];
        visited[sx][sy][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.x == ex && now.y == ey && now.check == true){
                return now.cnt;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!che(nx,ny)) continue;
                if(visited[nx][ny][now.check ? 1 : 0]) continue;
                if(arr[nx][ny] == 'X') continue;
                
                if(nx == lx && ny == ly){
                    q.offer(new Node(nx,ny,true,now.cnt + 1));
                    visited[nx][ny][1] = true;
                }else{
                    q.offer(new Node(nx,ny,now.check,now.cnt + 1));
                    visited[nx][ny][now.check ? 1 : 0] = true;
                }
            }
        }
        return -1;
    }//bfs end
    
    public static boolean che(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}