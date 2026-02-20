import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int weight;
        public Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int n,m,x,y;
    static List<Node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];

        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[y] = 0;

        dijkstra();

        int[] d = new int[n - 1];
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(i == y) continue;
            d[idx++] = dist[i];
        }

        Arrays.sort(d);

        int day = 1;
        int sum = 0;
        for(int i = 0; i < n - 1; i++){
            if(d[i] == Integer.MAX_VALUE){
                System.out.println(-1);
                return;
            }

            int round = d[i] * 2;

            if(round > x){
                System.out.println(-1);
                return;
            }

            if(sum + round > x){
                day++;
                sum = 0;
            }

            sum += round;
        }

        System.out.println(day);
    }//main end

    private static void dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(y,0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            int now = cur.end;

            if (cur.weight != dist[now]) continue;

            for(Node next : list[now]){
                if(dist[next.end] > dist[now] + next.weight){
                    dist[next.end] = dist[now] + next.weight;
                    q.offer(new Node(next.end, dist[next.end]));
                }
            }

        }
    }//dijkstra end
}//class end
