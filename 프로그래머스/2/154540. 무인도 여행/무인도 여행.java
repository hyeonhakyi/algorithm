import java.util.*;

class Node{
    int x;
    int y;
    int day;
    public Node(int x,int y,int day){
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

class Solution {
    static char[][] arr;
    static boolean[][] visited;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<Integer> list = new ArrayList<>();
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        arr = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            arr[i] = maps[i].toCharArray();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != 'X' && !visited[i][j]){
                    int day = Integer.parseInt(String.valueOf(arr[i][j]));
                    list.add(bfs(i,j,day));
                }
            }
        }
        if(list.isEmpty()){
            return new int[]{-1};
        }
        
        int[] answer = new int[list.size()];
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int bfs(int x,int y,int day){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,day));
        visited[x][y] = true;
        int totalDays = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            totalDays += now.day;
                
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 'X') continue;
                
                visited[nx][ny] = true;
                int nextDay = Integer.parseInt(String.valueOf(arr[nx][ny]));
                q.offer(new Node(nx,ny,nextDay));
            }
        }
        
        return totalDays;
    }//bfs end
    
    public boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}//class end