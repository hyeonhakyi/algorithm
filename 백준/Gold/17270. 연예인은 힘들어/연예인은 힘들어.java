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
    static List<Node>[] list;
    static int[] jDist;
    static int[] sDist;
    static int v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new List[v + 1];
        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }

        st = new StringTokenizer(br.readLine());
        int j = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        jDist = new int[v + 1];
        sDist = new int[v + 1];

        Arrays.fill(jDist,Integer.MAX_VALUE);
        Arrays.fill(sDist, Integer.MAX_VALUE);

        dijkstr(j,jDist);
        dijkstr(s,sDist);

        int minSum = Integer.MAX_VALUE;
        for(int i = 1; i <= v; i++){
            if(i == j || i == s) continue;
            minSum = Math.min(minSum, jDist[i] + sDist[i]);
        }

        int answer = -1;
        int minJDist = Integer.MAX_VALUE;
        for(int i = 1; i <= v; i++){
            if(i == s || i == j) continue;
            if(jDist[i] + sDist[i] != minSum) continue;
            if(jDist[i] > sDist[i]) continue;

            if(jDist[i] < minJDist){
                minJDist = jDist[i];
                answer = i;
            }else if(jDist[i] == minJDist && i < answer){
                answer = i;
            }
        }
        System.out.println(answer);
    }//main end

    private static void dijkstr(int start,int[] dist){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if (cur.weight > dist[cur.idx]) continue;

            for(Node next : list[cur.idx]){
                int nextWeight = dist[cur.idx] + next.weight;
                if(dist[next.idx] > nextWeight){
                    dist[next.idx] = nextWeight;
                    q.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }//dijkstr
}//class end
