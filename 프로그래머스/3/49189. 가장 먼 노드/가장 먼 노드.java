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
    static int[] dist;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        dist = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        for(int[] ver : edge){
            int s = ver[0];
            int e = ver[1];
            
            list[s].add(new Node(e,1));
            list[e].add(new Node(s,1));
        }
        
        dijkstr();
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 1; i <= n; i++){
            max = Math.max(max,dist[i]);
        }
        
        for(int i = 1; i <= n; i++){
            if(dist[i] == max){
                answer++;
            }
        }
        
        return answer;
    }//solution end
    
    private static void dijkstr(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1,0));
        dist[1] = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.weight > dist[now.idx]) continue;
            
            for(Node next : list[now.idx]){
                int nextWeight = dist[now.idx] + next.weight;
                
                if(dist[next.idx] > nextWeight){
                    dist[next.idx] = nextWeight;
                    q.offer(new Node(next.idx,dist[next.idx]));
                }
            }
        }
        return;
    }//dijkstr end
}//class end