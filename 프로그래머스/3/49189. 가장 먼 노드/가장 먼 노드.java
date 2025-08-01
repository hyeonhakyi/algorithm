import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] r : edge){
            list.get(r[0]).add(r[1]);
            list.get(r[1]).add(r[0]);
        }
        
        int[] d = new int[n+1];
        Arrays.fill(d,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        d[1] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list.get(now)){
                if(d[next] == -1){
                    d[next] = d[now] + 1;
                    q.add(next);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i <= n; i++){
            max = Math.max(max,d[i]);
        }
        
        int answer = 0;
        for(int i = 0; i <= n; i++){
            if(max == d[i]){
                answer++;
            }
        }
        
        return answer;
    }
}