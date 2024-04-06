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
    private static ArrayList<Node>[] list;
    private static int[] distance;
    private static boolean[] visited;
    private static int INF = 200000100;
    private static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        distance = new int[n+1];
        visited= new boolean[n+1];

        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,value));
            list[b].add(new Node(a,value));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int distA = 0;
        int distB = 0;

        distA += dijkstra(1,v1);
        distA += dijkstra(v1,v2);
        distA += dijkstra(v2,n);

        distB += dijkstra(1,v2);
        distB += dijkstra(v2,v1);
        distB += dijkstra(v1,n);

        int ans = 0;
        if(distA >= INF && distB >= INF){
            ans = -1;
        }else{
            ans = Math.min(distA,distB);
        }
        System.out.println(ans);
    }//main end

    private static int dijkstra(int start,int end){
        PriorityQueue<Node> que = new PriorityQueue<>();
        Arrays.fill(visited,false);
        Arrays.fill(distance,INF);

        que.offer(new Node(start,0));
        distance[start] = 0;

        while(!que.isEmpty()){
            Node now = que.poll();

            if(visited[now.idx]){
                continue;
            }
            visited[now.idx] = true;

            for(Node next : list[now.idx]){
                if(distance[next.idx] > now.value + next.value){
                    distance[next.idx] = now.value + next.value;
                    que.offer(new Node(next.idx,distance[next.idx]));
                }
            }
        }
        return distance[end];
    }//dijkstra end
}//class end
