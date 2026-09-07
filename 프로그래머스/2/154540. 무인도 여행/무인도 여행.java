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
    static boolean[][] visited;
    static char[][] arr;
    static int n,m;
    static List<Integer> answerList = new ArrayList<>();
    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();
        arr = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            arr[i] = maps[i].toCharArray();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && arr[i][j] != 'X'){
                    bfs(i,j);
                }
            }
        }
        
        if(answerList.size() == 0){
            return new int[]{-1};
        }else{
            answer = new int[answerList.size()];
            
            Collections.sort(answerList);
            for(int i = 0; i < answerList.size(); i++){
                answer[i] = answerList.get(i);
            }
            return answer;
        }
    }//solution end
    
    private static void bfs(int x,int y){
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
                
                sum += arr[nx][ny] - '0';
                q.offer(new Node(nx,ny));
                visited[nx][ny] = true;
            }
        }
        
        answerList.add(sum);
    }//bfs end
    
    private static boolean check(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}//class end