import java.util.*;

class Node{
    int x;
    int y;
    
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int n,m,answer;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        arr = new int[n + 2][m + 2];
        answer = n*m;
        
        for(int[] map : arr){
            Arrays.fill(map,-1);
        }
        
        for(int i = 0; i < n; i++){
            String str = storage[i];
            for(int j = 0; j < m; j++){
                char chr = str.charAt(j);
                arr[i + 1][j + 1] = chr - 'A';
            }
        }
        
        for(String commend : requests){
            int target = commend.charAt(0) - 'A';
            
            if(commend.length() == 2){
                allChange(target);
            }else{
                bfs(target);
            }
        }
        
        return answer;
    }//main end
    
    private static void allChange(int target){
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(arr[i][j] == target){
                    arr[i][j] = -1;
                    answer--;
                }
            }
        }
    }//allChange end
    
    private static void bfs(int target){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 2][m + 2];
        q.offer(new Node(0,0));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == target || arr[nx][ny] == -1){
                    if(arr[nx][ny] == target){
                        arr[nx][ny] = -1;
                        answer--;
                        visited[nx][ny] = true;
                        continue;
                    }
                    
                    q.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < n + 2 && y < m + 2;
    }
}//class end