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
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<Integer> list;
    static char[][] arr;
    static boolean[][] visited;
    public int[] solution(String[] maps) {
        list = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        arr = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < maps.length; i++){
            arr[i] = maps[i].toCharArray();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != 'X' && !visited[i][j]){
                    list.add(bfs(i,j));
                }
            }
        }
        
        if(list.size() == 0){
            return new int[] {-1};
        }else{
            int[] answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
            
            Arrays.sort(answer);
            
            return answer;
        }
    }//main end
    
    private static int bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        
        int sum = arr[x][y] - '0';
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 'X') continue;
                
                q.offer(new Node(nx,ny));
                visited[nx][ny] = true;
                sum += arr[nx][ny] - '0';
            }
        }
        
        return sum;
    }//bfs end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}//class end