import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[] arr;
    private static boolean[] visited;
    private static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        ans = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0,0);
    }//main end

    private static void dfs(int count,int idx){
        if(count == m){
            for(int i : ans){
                System.out.print(i+ " ");
            }
            System.out.println();
            return;
        }

        for(int i = idx; i < n; i++){
            if(!visited[i]){
                ans[count] = arr[i];
                dfs(count+1,i);
            }
        }
    }
}//class end
