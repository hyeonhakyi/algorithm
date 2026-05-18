import java.util.*;

class Solution {
    static class Edge{
        int idx;
        int weight;
        public Edge(int idx,int weight){
            this.idx = idx;
            this.weight = weight;
        }
    }
    
    static class Node implements Comparable<Node>{
        int idx;
        int intensity;
        public Node(int idx,int intensity){
            this.idx = idx;
            this.intensity = intensity;
        }
        
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.intensity,o.intensity);
        }
    }
    static List<Edge>[] list;
    static boolean[] isGate;
    static boolean[] isSummits;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        
        list = new ArrayList[n + 1];
        isGate = new boolean[n + 1];
        isSummits = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int gate : gates){
            isGate[gate] = true;
        }
        
        for(int summit : summits){
            isSummits[summit] = true;
        }
        
        for(int[] path : paths){
            int s = path[0];
            int e = path[1];
            int w = path[2];
            
            list[s].add(new Edge(e,w));
            list[e].add(new Edge(s,w));
        }

        int[] dist = djkstra(n,gates);
        
        int minSummit = Integer.MAX_VALUE;
        int minIntensity = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        
        for(int summit : summits){
            if(dist[summit] < minIntensity){
                minIntensity = dist[summit];
                minSummit = summit;
            }
        }
        
        return new int[] {minSummit,minIntensity};
    }//soliution end
    
    private static int[] djkstra(int n,int[] gates){
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        for(int gate : gates){
            dist[gate] = 0;
            q.offer(new Node(gate,0));
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.intensity > dist[now.idx]){
                continue;
            }
            
            if(isSummits[now.idx]){
                continue;
            }
            
            for(Edge next : list[now.idx]){
                if(isGate[next.idx]){
                    continue;
                }
                
                int weight = Math.max(next.weight,now.intensity);
                
                if(weight < dist[next.idx]){
                    q.offer(new Node(next.idx,weight));
                    dist[next.idx] = weight;
                }
            }
        }
        
        return dist;
    }//djkstra end
}//class end