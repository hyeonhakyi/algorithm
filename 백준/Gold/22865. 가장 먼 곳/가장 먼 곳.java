import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node>{
        int idx;
        int weight;
        public Node(int idx,int weight){
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight,o.weight);
        }
    }
    private static int n,a,b,c,m;
    private static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to,value));
            list[to].add(new Node(from,value));
        }

        long[] dist1 = dijkstr(a);
        long[] dist2 = dijkstr(b);
        long[] dist3 = dijkstr(c);

        int vertex = 0;
        long compareDistance = 0;
        for(int i = 1; i <= n; i++){

            long minDistance = Math.min(dist1[i],Math.min(dist2[i],dist3[i]));

            if(minDistance == compareDistance)continue;

            if(minDistance > compareDistance){
                compareDistance = minDistance;
                vertex = i;
            }
        }
        System.out.println(vertex);
    }//main end

    private static long[] dijkstr(int start){
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(start,0));

        long[] dist = new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[start] = 0;

        while(!que.isEmpty()){
            Node now = que.poll();

            int cur = now.idx;
            int distance = now.weight;

            if(dist[cur] < distance)continue;

            for(int i = 0; i < list[cur].size(); i++){
                int next_distance = distance + list[cur].get(i).weight;
                int next = list[cur].get(i).idx;

                if(dist[next] > next_distance){
                    dist[next] = next_distance;
                    que.offer(new Node(next,next_distance));
                }
            }
        }
        return dist;
    }
}//class end
