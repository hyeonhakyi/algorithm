import java.util.*;

class Node{
    int x;
    int y;
    int money;
    int dir;
    public Node(int x,int y,int money,int dir){
        this.x = x;
        this.y = y;
        this.money = money;
        this.dir = dir;
    }
}

class Solution {
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][][] arr;
    public int solution(int[][] board) {
        n = board.length;
        arr = new int[4][n][n];
        
        for(int x = 0; x < 4; x++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    arr[x][i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        bfs(board);
        
        return answer;
    }//main end
    
    private static void bfs(int[][] board){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,0,-1));
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.x == n - 1 && now.y == n - 1){
                answer = Math.min(answer,now.money);
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                int nextMoney = now.money;
                
                if(now.dir == -1){
                    nextMoney += 100;
                }else if(now.dir == d){
                    nextMoney += 100;
                }else{
                    nextMoney += 600;
                }
                
                if(!check(nx,ny)) continue;
                if(board[nx][ny] == 1) continue;
                
                if(!visited[nx][ny] || arr[d][nx][ny] >= nextMoney){
                    arr[d][nx][ny] = nextMoney;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx,ny,nextMoney,d));
                }
            }
        }
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }//check end
}//class end