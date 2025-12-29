import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[t + 1];

        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[t + 1][w + 1];

        for (int i = 1; i <= t; i++) {
            for(int j = 0; j <= w; j++) {
                int nowPos = 0;
                if(j % 2 == 0) {
                    nowPos = 1;
                }else{
                    nowPos = 2;
                }

                dp[i][j] = dp[i-1][j];

                if(j > 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                }

                if(arr[i] == nowPos){
                    dp[i][j]++;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i <= w; i++){
            answer = Math.max(answer, dp[t][i]);
        }
        System.out.println(answer);
    }//main end
}//class end
