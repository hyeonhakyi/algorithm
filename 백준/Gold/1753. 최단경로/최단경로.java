import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Node implements Comparable<Node>{
        int idx;
        int value;
        public Node(int idx,int value){
            this.idx = idx;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value,o.value);
        }
    }
    private static int v,e;
    private static ArrayList<Node>[] list;
    private static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[v+1];
        dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i = 0; i <= v; i++){
            list[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());


        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,value));
        }

        bfs(start);
        for(int i = 1; i<= v; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }//main end

    private static void bfs(int start){
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] visited = new boolean[v+1];
        que.offer(new Node(start,0));
        dist[start] = 0;

        while (!que.isEmpty()){
            Node now = que.poll();

            if(visited[now.idx]){
                continue;
            }
            visited[now.idx] = true;

            for(Node next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx] + next.value){
                    dist[next.idx] = dist[now.idx] + next.value;
                    que.offer(new Node(next.idx,dist[next.idx]));
                }
            }
        }
    }
}//class end
