import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int end;
        int weight;
        public Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.weight,o.weight);
        }
    }
    static int n,m,s,e,money;
    static List<Node>[] list;
    static int maxW;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
            maxW = Math.max(maxW, weight);
        }

        int lower = 0;
        int height = maxW;
        int answer = -1;

        while(lower <= height){
            int mid = (lower + height) / 2;
            if(can(mid)){
                answer = mid;
                height = mid - 1;
            }else{
                lower = mid + 1;
            }
        }

        System.out.println(answer);
    }//main end

    private static boolean can(int limit) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(s, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            int now = cur.end;
            int weight = cur.weight;


            if(weight != dist[now]) continue;
            if(weight > money) continue;
            if(now == e) return true;

            for(Node next : list[now]){
                if(next.weight > limit) continue;

                if(dist[next.end] > dist[now] + next.weight){
                    dist[next.end] = dist[now] + next.weight;
                    q.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
        return dist[e] <= money;
    }//dijkstra end
}//class end
