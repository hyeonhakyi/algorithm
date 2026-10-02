import java.util.*;

class Edge{
    int idx;
    int weight;
    public Edge(int idx,int weight){
        this.idx = idx;
        this.weight = weight;
    }
}

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
}

class Solution {
    static List<Edge>[] list;
    static boolean[] gate;
    static boolean[] summit;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        list = new ArrayList[n + 1];
        gate = new boolean[n + 1];
        summit = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i : gates){
            gate[i] = true;
        }
        
        for(int i : summits){
            summit[i] = true;
        }
        
        for(int[] path : paths){
            int s = path[0];
            int e = path[1];
            int w = path[2];
            
            list[s].add(new Edge(e,w));
            list[e].add(new Edge(s,w));
        }
        
        int[] dist = dijkstr(n,gates);
        
        int minSummit = Integer.MAX_VALUE;
        int minSummitValue = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        
        for(int i : summits){
            if(minSummitValue > dist[i]){
                minSummitValue = dist[i];
                minSummit = i;
                answer[0] = minSummit;
                answer[1] = minSummitValue;
            }
        }
        
        return answer;
    }//solution end
    
    private static int[] dijkstr(int n,int[] gates){
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i : gates){
            q.offer(new Node(i,0));
            dist[i] = 0;
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.weight > dist[now.idx]){
                continue;
            }
            
            if(summit[now.idx]) continue;
            
            for(Edge next : list[now.idx]){
                if(gate[next.idx]) continue;
                
                int weight = Math.max(now.weight,next.weight);
                
                if(dist[next.idx] > weight){
                    dist[next.idx] = weight;
                    q.offer(new Node(next.idx,dist[next.idx]));
                }
            }
        }
        
        return dist;
    }//dijkstr end
}//class end