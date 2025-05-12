import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int index;
        int weight;
        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int n,m;
    static ArrayList<Node>[] list;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1] = 0;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        diskstr();

        System.out.println(arr[n]);
    }//main end

    static void diskstr(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int vertex = node.index;

            if(visited[vertex]){
                continue;
            }

            visited[vertex] = true;

            for(Node n : list[vertex]){
                if(arr[n.index] > arr[vertex] + n.weight){
                    arr[n.index] = arr[vertex] + n.weight;

                    pq.offer(new Node(n.index,arr[n.index]));
                }
            }
        }
    }
}//class end
