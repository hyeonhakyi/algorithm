import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int idx;
        int weight;
        public Node(int idx,int weight){
            this.idx = idx;
            this.weight = weight;
        }
    }
    static int n,sec;
    static int answer = -1;
    static List<Node>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int fir = Integer.parseInt(st.nextToken());
        sec = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }

        visited = new boolean[n + 1];
        dfs(fir, 0, 0);

        System.out.println(answer);
    }//main end

    private static void dfs(int now,int sum,int maxWeight){
        if(answer != -1){
            return;
        }
        
        if(now == sec){
            answer = sum - maxWeight;
            return;
        }

        visited[now] = true;
        for(Node next : list[now]){
            if(visited[next.idx]) continue;
            dfs(next.idx,sum + next.weight,Math.max(next.weight,maxWeight));
        }
    }//dfs end
}//class end
