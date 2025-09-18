import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
    static int n,m,x;
    static ArrayList<Node>[] list;
    static ArrayList<Node>[] rList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        rList = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            rList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
            rList[end].add(new Node(start,weight));
        }

        int[] distFrom = dijkstr(list,x);
        int[] distTox = dijkstr(rList,x);

        int answer = 0;
        for(int i = 1; i <= n; i++){
            answer = Math.max(answer, distTox[i] + distFrom[i]);
        }

        System.out.println(answer);
    }//main end

    static int[] dijkstr(ArrayList<Node>[] list,int x){
        int[] dist = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[x] =0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(x,0));

        while(!q.isEmpty()){
            Node now = q.poll();
            int idx = now.end;
            int weight = now.weight;

            if(weight > dist[idx]) continue;

            for(Node next : list[idx]){
                if(dist[next.end] > weight + next.weight){
                    dist[next.end] = weight + next.weight;
                    q.add(new Node(next.end,dist[next.end]));
                }
            }
        }
        return dist;
    }//dijkstr end
}//class end
