import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,x,y,m;
    static int result = -1;
    static boolean[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            arr[x1][y1] = arr[y1][x1] = true;
        }

        dfs(0,x);
        System.out.println(result);
    }

    static void dfs(int count, int idx){
        if(idx == y){
            result = count;
            return;
        }

        visited[idx] = true;
        for(int i = 1; i <= n; i++){
            if(!visited[i] && arr[idx][i]){
                dfs(count+1,i);
            }
        }
    }
}
