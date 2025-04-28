import java.util.*;

class Node{
    int end;
    int weight;
    public Node(int end,int weight){
        this.end = end;
        this.weight = weight;
    }
}


class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<Node>> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] cost: costs){
            int start = cost[0];
            int end = cost[1];
            int weight = cost[2];
            
            list.get(start).add(new Node(end,weight));
            list.get(end).add(new Node(start,weight));
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);
        
        visited[0] = true;
        for(Node next : list.get(0)){
            q.offer(next);
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(visited[now.end]) continue;
            
            visited[now.end] = true;
            answer += now.weight;
            
            for(Node next : list.get(now.end)){
                if(!visited[next.end]){
                    q.offer(next);
                }
            }
        }
        
        
        return answer;
    }
}