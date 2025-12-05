import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Math.abs(n);
        
        if(n > 0){
            sb.append("1").append('\n');
        }else if(n == 0){
            sb.append("0").append('\n');
            sb.append("0");
            System.out.println(sb.toString());
            return;
        }else if(n < 0){
            sb.append((m % 2 == 0) ? "-1" : "1").append('\n');
        }

        long[] dp = new long[m+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= m; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
        }

        sb.append(dp[m]% 1000000000);
        System.out.println(sb.toString());
    }//main end
}//class end
