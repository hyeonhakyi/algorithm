import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n,l,r,x;
    static int[] arr;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println(answer);
    }//main end

    private static void dfs(int idx,int cnt,int sum,int min,int max){
        if(idx == n){
            if(cnt >= 2 && sum >= l && sum <= r && (max - min) >= x){
                answer++;
            }
            return;
        }

        int newMin = Math.min(arr[idx], min);
        int newMax = Math.max(arr[idx], max);
        dfs(idx + 1, cnt + 1, sum + arr[idx], newMin, newMax);
        dfs(idx + 1, cnt, sum, min, max);
    }//dfs end
}//class end
