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
    private static int n,m;
    private static int[][] arr;
    private static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        list = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to,value));
            list[to].add(new Node(from,value));
        }

        for(int i = 1; i<= n; i++){
            dijkstr(i);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j){
                    System.out.print("- ");
                }else{
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }//main end

    private static void dijkstr(int start){
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        que.offer(new Node(start,0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        while(!que.isEmpty()){
            Node now = que.poll();

            if(visited[now.idx])continue;
            visited[now.idx] = true;

            for(Node next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx] + next.weight){
                    dist[next.idx] = dist[now.idx] + next.weight;
                    arr[next.idx][start] = now.idx;
                    que.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }//floyd end
}//class end
