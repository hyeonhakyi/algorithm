import java.util.*;

class Node{
    int x;
    int y;
    int dir;
    int value;
    public Node(int x,int y,int dir,int value){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.value = value;
    }
}

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m,answer;
    static int[][][] arr;
    static boolean[][] visited;
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        m = board.length;
        visited = new boolean[n][m];
        arr = new int[4][n][m];
        
        for(int x = 0; x < 4; x++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    arr[x][i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        bfs(board);
        
        return answer;
    }
    
    public void bfs(int[][] board){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,-1,0));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowDir = now.dir;
            int nowValue = now.value;
            
            if(nowX == n - 1 && nowY == m - 1){
                answer = Math.min(answer,nowValue);
            }
            
            for(int d = 0; d < 4; d++){
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                int nextValue = nowValue;
                
                if(nowDir == -1){
                    nextValue += 100;
                }else if(nowDir == d){
                    nextValue += 100;
                }else{
                    nextValue += 600;
                }
                
                if(!check(nx,ny)) continue;
                if(board[nx][ny] == 1) continue;
                if(!visited[nx][ny] || arr[d][nx][ny] >= nextValue){
                    visited[nx][ny] = true;
                    arr[d][nx][ny] = nextValue;
                    q.offer(new Node(nx,ny,d,nextValue));  
                } 
            }
        }
    }
    
    public boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}