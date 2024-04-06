import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node>{
        int idx;
        int distance;
        public Node(int idx,int distance){
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance,o.distance);
        }
    }
    private static ArrayList<Node>[] list;
    private static int n,m,r;
    private static int[] items;
    private static int[] dist;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        dist = new int[n+1];

        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        items = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,dis));
            list[b].add(new Node(a,dis));
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            visited = new boolean[n+1];
            int answer = 0;

            Arrays.fill(dist,Integer.MAX_VALUE);

            dist[i] = 0;
            dijkstra(i);

            for(int j = 1; j <= n; j++){
                if(dist[j] <= m){
                    answer += items[j];
                }
            }
            max = Math.max(answer,max);
        }
        System.out.println(max);
    }//main end

    private static void dijkstra(int x){
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(x,0));

        while(!que.isEmpty()){
            Node now = que.poll();

            if(visited[now.idx]){
                continue;
            }
            visited[now.idx] = true;

            for(Node next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx] + next.distance){
                    dist[next.idx] = dist[now.idx] + next.distance;
                    que.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }//dijkstra end
}//class end
