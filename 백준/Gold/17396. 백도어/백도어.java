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
        long weight;
        public Node(int idx,long weight){
            this.idx = idx;
            this.weight =weight;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight,o.weight);
        }
    }
    private static ArrayList<Node>[] list;
    private static int n,m;
    private static boolean[] see;
    private static long[] dist;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        see = new boolean[n];
        list = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num == 1){
                see[i] = true;
            }else{
                see[i] = false;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,value));
            list[b].add(new Node(a,value));
        }

        dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;

        dijkstra();
        if(dist[n-1] == Long.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dist[n-1]);
        }
    }//main end

    private static void dijkstra(){
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(0,0));

        while(!que.isEmpty()){
            Node now = que.poll();

            if(visited[now.idx]){
                continue;
            }

            visited[now.idx] = true;

            for(Node next : list[now.idx]){
                if(next.idx != n-1 && see[next.idx])continue;
                if(dist[next.idx] > dist[now.idx] + next.weight){
                    dist[next.idx] = dist[now.idx] + next.weight;
                    que.offer(new Node(next.idx,dist[next.idx]));
                }
            }
        }
    }//dijkstra end
}//class end
