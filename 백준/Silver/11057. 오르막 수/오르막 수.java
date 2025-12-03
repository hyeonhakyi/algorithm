import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[10];
        Arrays.fill(dp,1);

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= 9; j++){
                dp[j] = (dp[j] + dp[j-1]) % 10007;
            }
        }

        int answer = 0;
        for(int i = 0; i <= 9; i++) {
            answer = (answer + dp[i]) % 10007;
        }
        System.out.println(answer);
    }//main end
}//class end
