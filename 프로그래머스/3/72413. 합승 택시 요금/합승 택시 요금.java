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
        return this.weight - o.weight;
    }
}

class Solution {
    static List<Node>[] list;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList[n + 1];
        
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] i : fares){
            int st = i[0];
            int e = i[1];
            int w = i[2];
            
            list[st].add(new Node(e,w));
            list[e].add(new Node(st,w));
        }
        
        int[] sDist = dijkstr(s,n);
        int[] aDist = dijkstr(a,n);
        int[] bDist = dijkstr(b,n);
        
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer,sDist[i] + aDist[i] + bDist[i]);
        }
        
        return answer;
    }//main end
    
    private static int[] dijkstr(int s,int n){
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(s,0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s] = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(visited[now.idx]) continue;
            visited[now.idx] = true;
            
            for(Node next : list[now.idx]){
                if(dist[next.idx] > next.weight + now.weight){
                    dist[next.idx] = next.weight + now.weight;
                    q.offer(new Node(next.idx,dist[next.idx]));
                }
            }
        }
        
        return dist;
    }//dijkstr end
}//class end