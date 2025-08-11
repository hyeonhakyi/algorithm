import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        ArrayList<Integer>[] list = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] i : roads){
            int start = i[0];
            int end = i[1];
            
            list[start].add(end);
            list[end].add(start);
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
                    q.offer(next);
                    dist[next] = dist[now] + 1;
                }
            }
        }
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}