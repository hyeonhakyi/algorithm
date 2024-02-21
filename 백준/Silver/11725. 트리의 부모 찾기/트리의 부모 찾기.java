import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        dfs(1);
        for(int i = 2; i <= n; i++){
            System.out.println(parents[i]);
        }

    }

    private static void dfs(int start){
        visited[start] = true;
        for(int i : list[start]){
            if(!visited[i]){
                parents[i] = start;
                dfs(i);
            }
        }
    }
}
