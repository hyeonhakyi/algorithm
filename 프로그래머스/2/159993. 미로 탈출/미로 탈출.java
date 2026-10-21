import java.util.*;

class Node{
    int x;
    int y;
    int cnt;
    int check;
    public Node(int x,int y,int cnt,int check){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.check = check;
    }
}//class end

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static int sx,sy,ex,ey;
    static char[][] arr;
    public int solution(String[] maps) {
        int answer = 0;
        
        arr = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            arr[i] = maps[i].toCharArray();
        }
        
        n = arr.length;
        m = arr[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }
                if(arr[i][j] == 'E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        
        answer = bfs();
        
        return answer;
    }//solution end
    
    private static int bfs(){
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];
        q.offer(new Node(sx,sy,0,0));
        visited[sx][sy][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            int nowCheck = now.check;
            if(now.x == ex && now.y == ey && now.check == 1){
                return now.cnt;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                int nextCheck = nowCheck;
                if(!check(nx,ny)) continue;
                if(arr[nx][ny] == 'X') continue;
                if(arr[nx][ny] == 'L'){
                    nextCheck = 1;
                }
                if(visited[nx][ny][nextCheck]) continue;
                if(nextCheck == 1){
                    q.offer(new Node(nx,ny,now.cnt + 1,1));
                    visited[nx][ny][1] = true;
                }else{
                    q.offer(new Node(nx,ny,now.cnt + 1,0));
                    visited[nx][ny][0] = true;
                }
            }
        }
        return -1;
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}//class end