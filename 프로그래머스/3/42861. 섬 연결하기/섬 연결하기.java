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
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<Node>> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] c : costs){
            int start = c[0];
            int end = c[1];
            int weight = c[2];
            
            list.get(start).add(new Node(end,weight));
            list.get(end).add(new Node(start,weight));
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);
        
        visited[0] = true;
        for(Node i : list.get(0)){
            q.offer(i);   
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(visited[now.idx]) continue;
            answer += now.weight;
            visited[now.idx] = true;
            
            for(Node i : list.get(now.idx)){
                if(!visited[i.idx]){
                    q.offer(i);   
                }
            }
        }
        
        return answer;
    }
}