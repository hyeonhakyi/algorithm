import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        
        for(int i = 4 ; i <= n; i++) {
            if(!dp[i-1] || !dp[i-3]){
                dp[i] = true;
            }else{
                dp[i] = false;
            }
        }

        System.out.println(dp[n] ? "SK" :"CY");
    }//main end
}//class end
