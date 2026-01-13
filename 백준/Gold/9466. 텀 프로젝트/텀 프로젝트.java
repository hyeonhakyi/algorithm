import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static boolean[] finished;
    static int[] arr;
    static int n,teamCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            teamCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++){
                if(!visited[i]){
                    dfs(i);
                }
            }

            sb.append(n - teamCount).append("\n");
        }//testCase end
        System.out.println(sb.toString());
    }//main end

    private static void dfs(int u){
        visited[u] = true;
        int next = arr[u];

        if(!visited[next]){
            dfs(next);
        }else if(!finished[next]){
            teamCount++;
            for(int i = next; i != u; i = arr[i]){
                teamCount++;
            }
        }

        finished[u] = true;
    }//dfs end
}//class end
