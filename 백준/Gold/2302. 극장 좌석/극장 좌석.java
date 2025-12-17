import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[0] = 1;
        if(n >= 1) dp[1] = 1;
        if(n >= 2) dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        int answer = 1;
        int preVip = 0;
        
        for(int i = 0; i < m; i++) {
            int vip = Integer.parseInt(br.readLine());

            int len = vip - preVip - 1;
            answer *= dp[len];
            preVip = vip;
        }

        int lastLen = n - preVip;
        answer *= dp[lastLen];
        
        System.out.println(answer);
    }//main end
}//class end
