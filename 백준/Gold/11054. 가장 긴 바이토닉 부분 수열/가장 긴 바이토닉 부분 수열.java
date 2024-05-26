import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] dp2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[j] >= dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for(int i = n - 1; i >= 0; i--){
            dp2[i] = 1;
            for(int j = n-1; j > i; j--){
                if(arr[i] > arr[j] && dp2[j] >= dp2[i]){
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            result = Math.max(result, dp[i] + dp2[i] - 1);
        }
        System.out.println(result);
    }//main end
}//class end
