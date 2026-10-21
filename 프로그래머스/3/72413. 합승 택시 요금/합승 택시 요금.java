import java.util.*;

class Node implements Comparable<Node>{
    int idx;
    int value;
    public Node(int idx,int value){
        this.idx = idx;
        this.value = value;
    }
    
    @Override
    public int compareTo(Node o){
        return Integer.compare(this.value,o.value);
    }
}

class Solution {
    static List<Node>[] list;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares){
            int start = fare[0];
            int end = fare[1];
            int value = fare[2];
            
            list[start].add(new Node(end,value));
            list[end].add(new Node(start,value));
        }
        
        int[] sDist = dijkstra(s,n);
        int[] aDist = dijkstra(a,n);
        int[] bDist = dijkstra(b,n);
        
        for(int i = 1; i <= n; i++){
            if(aDist[i] == Integer.MAX_VALUE || bDist[i] == Integer.MAX_VALUE || sDist[i] == Integer.MAX_VALUE) continue;
            answer = Math.min(answer,(aDist[i] + bDist[i] + sDist[i]));
        }
        
        return answer;
    }//solution end
    
    private static int[] dijkstra(int start, int n){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.value > dist[now.idx]) continue;
            for(Node next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx] + next.value){
                    dist[next.idx] = dist[now.idx] + next.value;
                    q.offer(new Node(next.idx,dist[next.idx]));
                }
            }
        }
        return dist;
    }//dijkstra end
}//class end