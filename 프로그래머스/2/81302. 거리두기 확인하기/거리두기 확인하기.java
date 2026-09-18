import java.util.*;

class Node{
    int x;
    int y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class FindNode{
    int x;
    int y;
    int dist;
    public FindNode(int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++){
            answer[i] = bfs(places[i]); 
        }
        
        return answer;
    }//solution end
    
    private static int bfs(String[] places){
        Queue<Node> q = new LinkedList<>();
        
        char[][] arr = new char[5][5];
        for(int i = 0; i < 5; i++){
            arr[i] = places[i].toCharArray();
        }
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(arr[i][j] == 'P'){
                    q.offer(new Node(i,j));
                }
            }
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(!find(now.x,now.y,arr)){
                return 0;
            }
        }
        
        return 1;
    }//bfs end
    
    private static boolean find(int x,int y,char[][] arr){
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        Queue<FindNode> q = new LinkedList<>();
        q.offer(new FindNode(x,y,0));
        
        while(!q.isEmpty()){
            FindNode now = q.poll();
            
            if(now.dist == 2){
                continue;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 'X') continue;
                
                if(arr[nx][ny] == 'P'){
                    return false;
                }
                
                visited[nx][ny] = true;
                q.offer(new FindNode(nx,ny,now.dist + 1));
            }
        }
        
        return true;
    }//find end
    
    private static boolean check(int x,int y){
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }//check end
}//class end