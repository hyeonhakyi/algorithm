import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new int[i + 1];
            for(int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = Arrays.copyOf(arr[n-1], arr[n-1].length);

        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[j] = arr[i][j] + Math.max(dp[j], dp[j+1]);
            }
        }
        System.out.println(dp[0]);
    }//main end
}//class end
