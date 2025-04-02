import java.util.*;

class Solution {
    static int n,m;
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        int container = n*m;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        int[][] map = new int[n+2][m+2];
        for(int[] arr : map){
            Arrays.fill(arr,-1);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char x = storage[i].charAt(j);
                map[i+1][j+1] = x - 'A';
            }
        }
        
        for(String command: requests){
            int target = command.charAt(0) - 'A';
            if(command.length() == 2){
                for(int i = 1; i < n + 1; i++){
                    for(int j = 1; j < m+1; j++){
                        if(map[i][j] == target){
                            map[i][j] = -1;
                            container--;
                        }
                    }
                }
            }else{
                boolean[][] visited = new boolean[n+2][m+2];
                ArrayDeque<int[]> q = new ArrayDeque<>();
                visited[0][0] = true;
                q.add(new int[]{0,0});
                
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    
                    for(int i = 0; i < 4; i++){
                        int mx = x + dx[i];
                        int my = y + dy[i];
                        
                        if(canGo(mx,my) && !visited[mx][my] && (map[mx][my] == target || map[mx][my] == -1)){
                            if(map[mx][my] == target){
                                container--;
                                map[mx][my] = -1;
                                visited[mx][my] = true;
                                continue;
                            }
                            q.offer(new int[]{mx,my});
                            visited[mx][my] = true;
                        }
                    }
                }
            }
        }
        
        return container;
    }
    
    static boolean canGo(int x,int y){
        return x >= 0 && y >= 0 && x < n + 2 && y < m +2;
    }
}