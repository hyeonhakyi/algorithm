import java.util.*;

class Node{
    int x;
    int y;
    int dist;
    int value;
    public Node(int x,int y,int dist,int value){
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.value = value;
    }
}

class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int n,answer;
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        bfs(board);
        
        return answer;
    }//solution end
    
    private static void bfs(int[][] arr){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,-1,0));
        int[][][] cost = new int[n][n][4];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(cost[i][j],Integer.MAX_VALUE);
            }
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                int nextValue = now.value;
                
                if(!check(nx,ny)) continue;
                if(arr[nx][ny] == 1) continue;
                
                if(now.dist == -1){
                    nextValue += 100;
                }else if(now.dist == d){
                    nextValue += 100;
                }else{
                    nextValue += 600;
                }
                
                if(cost[nx][ny][d] > nextValue){
                    cost[nx][ny][d] = nextValue;
                    q.offer(new Node(nx,ny,d,nextValue));
                }
            }
            
            for(int i = 0; i < 4; i++){
                answer = Math.min(answer,cost[n - 1][n - 1][i]);
            }
        }
        
        return;
    }//bfs end
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}//class end