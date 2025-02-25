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
    static char[][] arr;
    static int n,m,sx,sy,lx,ly,ex,ey;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        arr = new char[n][m];
        
        for(int i = 0; i < n; i++){
            arr[i] = maps[i].toCharArray();
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
                if(arr[i][j] == 'L'){
                    lx = i;
                    ly = j;
                }
                if(arr[i][j] == 'E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        answer = calculation();
        
        return answer;
    }//solution end
    
    private static int calculation(){
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];
        q.offer(new Node(sx,sy,0,false));
        visited[sx][sy][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                int cnt = now.cnt + 1;
                boolean che = now.check;
                int checkL = 0;
                
                if(nx == ex && ny == ey && che == true){
                    return now.cnt + 1;
                }
                
                if(!check(nx,ny)) continue;
                if(arr[nx][ny] == 'L' || che){
                    che = true;
                    checkL = 1;
                }
                if(visited[nx][ny][checkL]) continue;
                if(arr[nx][ny] == 'X') continue;
                
                visited[nx][ny][checkL] = true;
                q.offer(new Node(nx,ny,cnt,che));
            }
        }
        return -1;
    }//calculation end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}