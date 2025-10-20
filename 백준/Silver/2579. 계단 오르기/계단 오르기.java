import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[301];
        int[] dp = new int[301];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        dp[2] = arr[2] + arr[1];
        dp[3] = Math.max(arr[2],arr[1]) + arr[3];

        for(int i = 4; i <= 300; i++){
            dp[i] = Math.max(arr[i - 1] + dp[i - 3],dp[i-2]) + arr[i];
        }

        System.out.println(dp[n]);
    }//main end
}//class end
