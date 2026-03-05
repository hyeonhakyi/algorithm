import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int idx;
        int weight;
        public Node(int idx,int weight){
            this.idx = idx;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int n,m;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        int[] distY = dijkstra(x, -1);
        int[] distZ = dijkstra(y, -1);

        int first = 0;
        if(distY[y] >= Integer.MAX_VALUE || distZ[z] >= Integer.MAX_VALUE){
            first = -1;
        }else{
            first = distY[y] + distZ[z];
        }

        int second = 0;
        int[] distNoY = dijkstra(x, y);
        if(distNoY[z] >= Integer.MAX_VALUE){
            second = -1;
        }else{
            second = distNoY[z];
        }

        System.out.println(first + " " + second);
    }//main end

    private static int[] dijkstra(int start,int ban){
        int[] dist = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));

        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.weight != dist[now.idx]) continue;
            if(now.idx == ban) continue;

            for(Node next : list[now.idx]){
                if(next.idx == ban) continue;

                int nextWeight = dist[now.idx] + next.weight;
                if(nextWeight < dist[next.idx]){
                    dist[next.idx] = nextWeight;
                    q.offer(new Node(next.idx, nextWeight));
                }
            }
        }

        return dist;
    }//dijkstra end
}//class end
