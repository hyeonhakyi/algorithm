import java.util.*;

class Solution {
    static List<Integer>[] list;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        list = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] r : roads){
            int s = r[0];
            int e = r[1];
            
            list[s].add(e);
            list[e].add(s);
        }
        
        int[] dist = bfs(n,destination);
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }//solution end
    
    private static int[] bfs(int n,int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int[] dist = new int[n + 1];
        Arrays.fill(dist,-1);
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list[now]){
                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
        
        return dist;
    }//bfs end
}//class end