import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> gr = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            gr.add(new ArrayList<>());
        }
        
        for(int[] road : roads){
            int n1 = road[0];
            int n2 = road[1];
            gr.get(n1).add(n2);
            gr.get(n2).add(n1);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        dist[destination] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : gr.get(now)){
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
    }
}