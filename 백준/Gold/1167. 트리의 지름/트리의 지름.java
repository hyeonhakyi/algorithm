import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int idx;
        int value;
        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    private static int v;
    private static ArrayList<Node> edges[];
    private static boolean[] visited;
    private static int position;
    private static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        v = Integer.parseInt(br.readLine());
        edges = new ArrayList[v+1];
        visited = new boolean[v+1];

        for(int i = 0; i <= v; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < v; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next == -1){
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                edges[idx].add(new Node(next, cost));
            }
        }

        dfs(1,0);

        visited = new boolean[v+1];
        dfs(position,0);

        System.out.println(max);
    }//main end

    private static void dfs(int v,int len){
        if(len > max){
            max = len;
            position = v;
        }

        visited[v] = true;
        for(int i = 0; i < edges[v].size(); i++){
            Node next = edges[v].get(i);
            if(!visited[next.idx]){
                dfs(next.idx,len + next.value);
            }
        }
    }//dfs end
}//class end
