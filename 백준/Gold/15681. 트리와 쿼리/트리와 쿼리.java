import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] list;
    static int[] tree;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        tree = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(tree[num]).append("\n");
        }

        System.out.println(sb.toString());
    }//main end

    private static void dfs(int u) {
        visited[u] = true;
        tree[u] = 1;

        for(int v : list[u]) {
            if(!visited[v]) {
                dfs(v);
                tree[u] += tree[v];
            }
        }
    }//dfs end
}//class end
