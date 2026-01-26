import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        
        int idx = 0;
        int count = 0;
        int total = 0;
        int end = 0;
        
        while(count < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= end){
                q.offer(jobs[idx++]);
            }
            
            if(q.isEmpty()){
                end = jobs[idx][0];
            }else{
                int[] now = q.poll();
                total += now[1] + end - now[0];
                end += now[1];
                count++;
            }
        }
        
        return total / jobs.length;
    }//main end
}//class end