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
        return this.value - o.value;
    }
}

class Solution {
    static List<Node>[] list;
    static int[] dist;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        list = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        
        dist = new int[N + 1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(dist,Integer.MAX_VALUE);
        }
        
        for(int[] ro : road){
            int a = ro[0];
            int b = ro[1];
            int c = ro[2];
            
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        
        bfs();
        
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        
        return answer;
    }//solution end
    
    private static void bfs(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1,0));
        dist[1] = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(Node next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx] + next.value){
                    dist[next.idx] = dist[now.idx] + next.value;
                    q.offer(new Node(next.idx,dist[next.idx]));
                }
            }
        }
        return;
    }//bfs end
}//class end