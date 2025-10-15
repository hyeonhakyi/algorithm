import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int idx;
        int weight;
        public Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
    }
    static int n,q;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(bfs(k,v)).append("\n");
        }

        System.out.println(sb.toString());
    }//main end

    static int bfs(int k,int v){
        boolean[] visited = new boolean[n+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = true;

        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();

            for(Node node : list[cur]){
                if(!visited[node.idx] && node.weight >= k){
                    visited[node.idx] = true;
                    q.add(node.idx);
                    count++;
                }
            }
        }
        return count;
    }
}//class end
