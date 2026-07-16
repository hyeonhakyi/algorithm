import java.util.*;

class Node{
    int idx;
    int weight;
    public Node(int idx,int weight){
        this.idx = idx;
        this.weight = weight;
    }
}

class Solution {
    static List<Node>[] list;
    static int[] dist;
    static int answer;
    public int solution(int N, int[][] road, int K) {
        answer = 0;
        
        list = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] i : road){
            int s = i[0];
            int e = i[1];
            int w = i[2];
            
            list[s].add(new Node(e,w));
            list[e].add(new Node(s,w));
        }
        
        dist = new int[N + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        
        bfs(K);
        
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        
        return answer;
    }//solution end
    
    private static void bfs(int K){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,0));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(Node next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx] + next.weight){
                    dist[next.idx] = dist[now.idx] + next.weight;
                    q.offer(new Node(next.idx,dist[next.idx]));
                }
            }
        }
        return;
    }//bfs end
}//class end