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
}//Node end

class Solution {
    static List<Node>[] list;
    static boolean[] visited;
    public int solution(int n, int[][] costs) {
        list = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] c : costs){
            int s = c[0];
            int e = c[1];
            int w = c[2];
            
            list[s].add(new Node(e,w));
            list[e].add(new Node(s,w));
        }
        
        visited = new boolean[n];
        
        int answer = dijkstra();
        
        return answer;
    }//solution end
    
    private static int dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0,0));
        int sum = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if (visited[now.idx]) continue;   // 수정: 꺼냈을 때 방문 체크
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