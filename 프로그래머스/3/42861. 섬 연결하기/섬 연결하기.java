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
}

class Solution {
    static List<Node>[] list;
    static boolean[] visited;
    public int solution(int n, int[][] costs) {
        list = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        
        visited = new boolean[n];
        for(int[] cost : costs){
            int s = cost[0];
            int e = cost[1];
            int w = cost[2];
            
            list[s].add(new Node(e,w));
            list[e].add(new Node(s,w));
        }
        
        return dijkstra();
    }//solution end
    
    private static int dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0,0));
        int sum = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(visited[now.idx]) continue;
            visited[now.idx] = true;
            sum += now.weight;
            
            for(Node next : list[now.idx]){
                if(!visited[next.idx]){
                    q.offer(new Node(next.idx,next.weight));
                }
            }
        }
        
        return sum;
    }//dijkstra end
}//class end