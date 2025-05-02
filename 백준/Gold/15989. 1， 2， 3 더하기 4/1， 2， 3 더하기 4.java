import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[10001][4]; // dp[i][j]: i를 1~j까지 숫자만 사용해 만드는 경우의 수
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 0;
        
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        
        for(int i = 4; i < 10001; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i - 3][3];
        }
        
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            int sum = dp[n][1] + dp[n][2] + dp[n][3];
            System.out.println(sum);
        }
    }
}
