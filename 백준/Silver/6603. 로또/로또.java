import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0){
                break;
            }
            arr = new int[k];
            visited = new boolean[k];
            ans = new int[6];
            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            System.out.println();
        }
    }

    static void dfs(int count,int start){
        if(count == 6){
            for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < k; i++){
            if(!visited[i]){
                visited[i] = true;
                ans[count] = arr[i];
                dfs(count+1,i+1);
                visited[i] = false;
            }
        }
    }
}
