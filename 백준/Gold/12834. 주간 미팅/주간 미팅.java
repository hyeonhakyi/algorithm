
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node> {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    private static int v;
    private static ArrayList<Node>[] list;
    private static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        list = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        int a = 0;
        int b = 0;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int[] start = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i= 0; i < n; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, value));
            list[to].add(new Node(from, value));
        }

        int result = 0;
        for(int starts : start){
            dijkstr(starts);
            if(dist[a] != Integer.MAX_VALUE){
                result += dist[a];
            }else{
                result += -1;
            }
            if(dist[b] != Integer.MAX_VALUE){
                result += dist[b];
            }else{
                result += -1;
            }
        }
        System.out.println(result);
    }//main end

    private static void dijkstr(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        boolean[] visited = new boolean[v+1];
        dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.idx])continue;
            visited[now.idx] = true;

            for(Node next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx] + next.weight){
                    dist[next.idx] = dist[now.idx] + next.weight;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }//dijkstra end
}//class end
