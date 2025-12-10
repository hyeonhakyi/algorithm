import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];

        for(int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i],dp[i-1]);

            if(i <= n){
                int next = i + t[i];
                if(next <= n + 1){
                    dp[next] = Math.max(dp[next],dp[i] + p[i]);
                }
            }
        }

        System.out.println(dp[n+1]);
    }//main end
}//class end
