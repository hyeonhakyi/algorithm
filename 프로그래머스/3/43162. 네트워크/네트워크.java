import java.util.*;

class Solution {
    public static boolean[] visited;
    public static Queue<Integer> que = new LinkedList<>();
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i,computers,n);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void bfs(int i,int[][] computer,int n){
        que.offer(i);
        visited[i] = true;
        
        while(!que.isEmpty()){
            int value = que.poll();
            
            for(int j = 0; j < n; j++){
                if(!visited[j] && computer[value][j] == 1){
                    
                    visited[j] = true;
                    que.offer(j);
                }
            }   
        }
    }
}