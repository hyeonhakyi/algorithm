import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    private static int n,m;
    private static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.get(from).add(new Node(to, value));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(result(start,end));
    }//main end

    private static int result(int start,int end){
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        que.offer(new Node(start,0));

        while(!que.isEmpty()){
            Node now = que.poll();
            if(now.idx == end){
                return now.value;
            }
            visited[now.idx] = true;
            for(Node i : list.get(now.idx)){
                if(!visited[i.idx]){
                    que.offer(new Node(i.idx,i.value+now.value));
                }
            }
        }
        return -1;
    }
}//class end
