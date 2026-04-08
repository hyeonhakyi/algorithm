import java.util.*;

class Node implements Comparable<Node>{
    int idx;
    int weight;
    public Node(int idx,int weight){
        this.idx = idx;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node o){
        return Integer.compare(this.weight,o.weight);
    }
}//Node end

class Solution {
    static List<Node>[] list;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] i : fares){
            int se = i[0];
            int e = i[1];
            int w = i[2];
            
            list[se].add(new Node(e,w));
            list[e].add(new Node(se,w));
        }
        
        int[] aDist = findDist(a,n);
        int[] bDist = findDist(b,n);
        int[] sDist = findDist(s,n);
        
        for(int i = 1; i <= n; i++){
            if (sDist[i] == Integer.MAX_VALUE || aDist[i] == Integer.MAX_VALUE || bDist[i] == Integer.MAX_VALUE) continue;
            answer = Math.min(answer, sDist[i] + aDist[i] + bDist[i]);
        }
        
        return answer;
    }//solution end
    
    private static int[] findDist(int start,int n){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if (now.weight > dist[now.idx]) continue;
            
            for(Node next : list[now.idx]){
                int nextWeight = dist[now.idx] + next.weight;
                if(nextWeight < dist[next.idx]){
                    dist[next.idx] = nextWeight;
                    q.offer(new Node(next.idx,nextWeight));
                }
            }
        }
        return dist;
    }//findDist end
}//class end