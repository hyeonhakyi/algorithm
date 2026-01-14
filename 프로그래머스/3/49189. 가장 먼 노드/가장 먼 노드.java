import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        
        for(int[] e : edge){
            int v = e[0];
            int t = e[1];
            
            list[v].add(t);
            list[t].add(v);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist,-1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list[now]){
                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(dist[i],max);
        }
        
        for(int i = 1; i <= n; i++){
            if(max == dist[i]){
                answer++;
            }
        }
        
        return answer;
    }//main end
}//class end