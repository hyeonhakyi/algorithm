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
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        
        ArrayList<Node>[] list = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList();
        }
        
        for(int[] r : road){
            int s = r[0];
            int e = r[1];
            int w = r[2];
            
            list[s].add(new Node(e,w));
            list[e].add(new Node(s,w));
        }
        
        int[] dist = cal(1,N,list,K);
        
        for(int i = 2; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }

        return answer;
    }
    
    public int[] cal(int start,int n,ArrayList<Node>[] list,int k){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
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
        return dist;
    }//cal end
}