import java.util.*;

class Node implements Comparable<Node>{
    int end;
    int weight;
    
    public Node(int end,int weight){
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node o){
        return Integer.compare(this.weight,o.weight);
    }
}

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        ArrayList<Node>[] list = new ArrayList[n+1];
        boolean[] isGate = new boolean[n+1];
        boolean[] isSummit = new boolean[n+1];
        
        for(int g : gates){
            isGate[g] = true;
        }
        
        for(int s : summits){
            isSummit[s] = true;
        }
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] i : paths){
            int start = i[0];
            int end = i[1];
            int weight = i[2];
            
            list[start].add(new Node(end,weight));
            list[end].add(new Node(start,weight));
        }
        
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        
        for(int g : gates){
            dist[g] = 0;
            q.offer(new Node(g,0));
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            int nowI = now.end;
            int nowWeight = now.weight;
            
            if(nowWeight > dist[nowI]) continue;
            if(isSummit[nowI]) continue;
            
            for(Node next : list[nowI]){
                int end = next.end;
                int weight = next.weight;
                if(isGate[end]) continue;
                
                int nextWeight = Math.max(nowWeight,weight);
                if(dist[end] > nextWeight){
                    dist[end] = nextWeight;
                    q.offer(new Node(end,nextWeight));
                }
            }
        }
        
        Arrays.sort(summits);
        int bestSummit = -1;
        int bestWeight = INF;
        for(int s : summits){
            if(dist[s] < bestWeight){
                bestWeight = dist[s];
                bestSummit = s;
            }
        }
        
        return new int[]{bestSummit,bestWeight};
    }
}