import java.util.*;

class Node{
    int x;
    int y;
    int cnt;
    int dist;
    public Node(int x,int y,int cnt,int dist){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.dist = dist;
    }
}

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n;
    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        answer = bfs(board);
        
        return answer;
    }//solution end
    
    private static int bfs(int[][] board){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,0,-1));
        int[][][] cost = new int[n][n][4];
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(cost[i][j],Integer.MAX_VALUE);
            }
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            int nowDist = now.dist;
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                int nextValue = now.cnt;
                
                if(!check(nx,ny)) continue;
                if(board[nx][ny] == 1) continue;
                
                if(nowDist == -1){
                    nextValue += 100;
                }else if(nowDist == d){
                    nextValue += 100;
                }else{
                    nextValue += 600;
                }
                
                if(cost[nx][ny][d] > nextValue){
                    cost[nx][ny][d] = nextValue;
                    q.offer(new Node(nx,ny,nextValue,d));
                }
            }
        }
        
        for(int i = 0; i < 4; i++){
            answer = Math.min(answer,cost[n-1][n-1][i]);
        }
        
        return answer;
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }//check end
}//class end