import java.util.*;

class Node{
    int x;
    int y;
    int weight;
    int dist;
    public Node(int x,int y,int weight,int dist){
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.dist = dist;
    }
}

class Solution {
    static int n;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        
        answer = bfs(board);
        
        return answer;
    }//solution end
    
    private static int bfs(int[][] arr){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,0,-1));
        
        int[][][] cost = new int[n][n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        
        while(!q.isEmpty()){
            Node cur = q.poll();
            int nowX = cur.x;
            int nowY = cur.y;
            
            for(int d = 0; d < 4; d++){
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                int nextWeight;
                
                if(!check(nx,ny)) continue;
                if(arr[nx][ny] == 1) continue;
                
                // 수정: 첫 이동은 무조건 100
                if(cur.dist == -1){
                    nextWeight = cur.weight + 100;
                }
                // 수정: 같은 방향이면 100
                else if(cur.dist == d){
                    nextWeight = cur.weight + 100;
                }
                // 수정: 방향 전환이면 600
                else{
                    nextWeight = cur.weight + 600;
                }
                if(cost[nx][ny][d] > nextWeight){
                    cost[nx][ny][d] = nextWeight;
                    q.offer(new Node(nx,ny,nextWeight,d));
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int d = 0; d < 4; d++){
            result = Math.min(result, cost[n - 1][n - 1][d]);
        }

        return result;    
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}//class end