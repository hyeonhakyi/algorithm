import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {        
        List<Integer>[] list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] r : roads){
            list[r[0]].add(r[1]);
            list[r[1]].add(r[0]);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist,-1);
        dist[destination] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list[now]){
                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
        
        int[] answer = new int[sources.length];
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }//main end
}//class end