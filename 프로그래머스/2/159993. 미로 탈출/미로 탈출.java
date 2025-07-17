import java.util.*;

class Node{
    int x;
    int y;
    int cnt;
    boolean check;
    public Node(int x,int y,int cnt,boolean check){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.check = check;
    }
}

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] arr;
    static int n,m,sx,sy,lx,ly,ex,ey;
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        arr = new char[n][m];
        
        for(int i = 0; i < n; i++){
            arr[i] = maps[i].toCharArray();
            for(int j = 0; j < m; j++){
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
        answer = cal();
        
        return answer;
    }
    
    public int cal(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx,sy,0,false));
        boolean[][][] visited = new boolean[n][m][2];
        visited[sx][sy][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
        
            
            
            for(int d = 0; d < 4; d++){
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                int cnt = now.cnt + 1;
                boolean nowCheck = now.check;
                int checkL = 0;
                
                if(nowCheck == true && nx == ex && ny == ey){
                    return cnt;
                }
                
                if(!check(nx,ny)) continue;
                
                if(arr[nx][ny] == 'L' || nowCheck){
                    nowCheck = true;
                    checkL = 1;
                }
                
                if(visited[nx][ny][checkL]) continue;
                if(arr[nx][ny] == 'X') continue;
                
                visited[nx][ny][checkL] = true;
                q.offer(new Node(nx,ny,cnt,nowCheck));
            }
        }
        return -1;
    }//cal end
    
    public boolean check(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}