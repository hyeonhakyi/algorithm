import java.util.*;

class Node implements Comparable<Node>{
    int idx;
    int start;
    int end;
    public Node(int idx,int start,int end){
        this.idx = idx;
        this.start = start;
        this.end = end;
    }
        
    @Override
    public int compareTo(Node o){
        if(o.end == this.end){
            if(o.start == this.start){
                return Integer.compare(this.idx,o.idx);
            }
            return Integer.compare(this.start,o.start);
        }
        return Integer.compare(this.end,o.end);
    }
}

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        int n = jobs.length;
        int time = 0;
        int total = 0;
        int idx = 0;
        int count = 0;
        while(count < n){
            while(idx < n && jobs[idx][0] <= time){
                q.offer(new Node(idx,jobs[idx][0],jobs[idx][1]));
                idx++;
            }
            
            if(q.isEmpty()){
                time = jobs[idx][0];
            }else{
                Node now = q.poll();
                
                time += now.end;
                
                total += time - now.start;
                
                count++;
            }
        }
        
        return total / n;
    }//solution end
}//class end