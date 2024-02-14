import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int n,m,u,v,count;
    static boolean[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for(int t = 0; t < m; t++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            arr[u][v] = arr[v][u] = true;
        }
        for(int i = 1; i < n+1; i++){
            if(!visited[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void DFS(int cnt){
        visited[cnt] = true;
        for(int i =1; i < n+1; i++){
            if(!visited[i] && arr[cnt][i]){
                DFS(i);
            }
        }
    }
}
