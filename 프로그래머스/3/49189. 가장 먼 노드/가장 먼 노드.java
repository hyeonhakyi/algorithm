import java.util.*;

class Solution {
    static int[] dist;
    static boolean[] visited;
    static List<Integer>[] list;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        dist = new int[n + 1];
        Arrays.fill(dist,-1);
        dist[1] = 1;
        
        visited = new boolean[n + 1];
        visited[1] = true;
        
        for(int[] i : edge){
            int s = i[0];
            int e = i[1];
            list[s].add(e);
            list[e].add(s);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list[now]){
                if(!visited[next]){
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i : dist){
            max = Math.max(max,i);
        }
        
        for(int i : dist){
            if(i == max){
                answer++;
            }
        }
        
        return answer;
    }//solution end
}//class end