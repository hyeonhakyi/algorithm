import java.util.*;

class Node implements Comparable<Node> {
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
    static ArrayList<Node>[] list;
    static int k,n;
    static int[] dist;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        k = K;
        n = N;
        list = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        
        dist = new int[N + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        
        for(int[] r : road){
            int start = r[0];
            int end = r[1];
            int weight = r[2];
            
            list[start].add(new Node(end,weight));
            list[end].add(new Node(start,weight));
        }
        
        dijkstra();
        
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        
        return answer;
    }//main end
    
    public static void dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1,0));
        boolean[] visited = new boolean[n + 1];
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(visited[now.idx]) continue;
            visited[now.idx] = true;
            
            for(Node next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx] + next.weight){
                    dist[next.idx] = dist[now.idx] + next.weight;
                    q.offer(new Node(next.idx,dist[next.idx]));
                }
            }
        }
    }//dijkstra end
}