import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int end;
        int weight;
        public Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    static List<Node>[] list;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int num = findWeight(s, e);
            sb.append(num).append("\n");
        }

        System.out.println(sb.toString());
    }//main end

    private static int findWeight(int start,int end){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start,0));
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int now = cur.end;
            int weight = cur.weight;

            if(now == end) return weight;

            for(Node next : list[now]){
                if(visited[next.end]) continue;
                visited[next.end] = true;
                q.offer(new Node(next.end, weight + next.weight));
            }
        }

        return 0;
    }//findWeight end
}//class end
