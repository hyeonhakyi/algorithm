import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] e : edge){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
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
        for(int i = 0; i < n + 1; i++){
            max = Math.max(d[i],max);
        }
        
        int answer = 0;
        for(int i = 0; i < n + 1; i++){
            if(d[i] == max){
                answer++;
            }
        }
        
        return answer;
    }
}