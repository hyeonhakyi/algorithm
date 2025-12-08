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
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static boolean[][] visited;
    static int[][] arr;
    static ArrayList<Integer> sizes;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        arr = new int[n][m];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(arr[i],-1);
        }
        
        sizes = new ArrayList<>();
        int compId = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    int size = bfs(land,i,j,compId);
                    sizes.add(size);
                    compId++;
                }
            }
        }
        
        for(int j = 0; j < m; j++){
            int total = 0;
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++){
                if(land[i][j] == 1){
                    int id = arr[i][j];
                    if(set.add(id)){
                        total += sizes.get(id);
                    }
                }
            }
            answer = Math.max(answer,total);
        }
        
        return answer;
    }//main end
    
    private static int bfs(int[][] land,int x,int y,int compId){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        arr[x][y] = compId;
        int size = 1;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(land[nx][ny] != 1) continue;
                
                visited[nx][ny] = true;
                arr[nx][ny] = compId;
                q.offer(new Node(nx,ny));
                size++;
            }
        }
        
        return size;
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//visited end
}