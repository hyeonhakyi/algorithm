import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node> {
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
    private static int n,m,x;
    private static ArrayList<Node>[] list,r_list;
    private static int[] dist,r_dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());


        dist = new int[n+1];
        r_dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(r_dist,Integer.MAX_VALUE);
        list = new ArrayList[n+1];
        r_list = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
            r_list[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to,value));
            r_list[to].add(new Node(from,value));
        }

        djkstr(list,dist,x);
        djkstr(r_list,r_dist,x);

        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max,dist[i] + r_dist[i]);
        }

        System.out.println(max);
    }//main end

    private static void djkstr(ArrayList<Node>[] list,int[] dist,int start){
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(start,0));
        dist[start] = 0;

        while(!que.isEmpty()){
            Node now = que.poll();
            for(Node next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx] + next.value){
                    dist[next.idx] = dist[now.idx] + next.value;
                    que.offer(new Node(next.idx,dist[next.idx]));
                }
            }
        }
    }//djkstr end
}//class end
