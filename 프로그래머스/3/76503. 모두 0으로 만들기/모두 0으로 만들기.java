import java.util.*;

class Solution {
    static List<Integer>[] list;
    static int n;
    static List<Integer> order;
    public long solution(int[] a, int[][] edges) {
        n = a.length;
        
        long totalWeight = 0;
        long[] weight = new long[n];
        
        for(int i = 0; i < n; i++){
            totalWeight += a[i];
            weight[i] = a[i];
        }
        
        if(totalWeight != 0){
            return - 1;
        }
        
        list = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int s = edge[0];
            int e = edge[1];
            
            list[s].add(e);
            list[e].add(s);
        }
        
        int[] parents = findParents();
        
        long answer = 0;
        
        for(int i = order.size() - 1; i > 0; i--){
            int child = order.get(i);
            int par = parents[child];
            
            answer += Math.abs(weight[child]);
            weight[par] += weight[child];
        }
        
        return answer;
    }//solution end
    
    private static int[] findParents(){
        Queue<Integer> q = new LinkedList<>();
        order = new ArrayList<>();
        
        int[] parents = new int[n];
        boolean[] visited = new boolean[n];
        
        q.offer(0);
        visited[0] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            order.add(now);
            
            for(int next : list[now]){
                if(!visited[next]){
                    parents[next] = now;
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return parents;
    }//findParents
}//class end