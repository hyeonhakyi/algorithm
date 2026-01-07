import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = INF;

        for(int f = 0; f < 3; f++){
            int[][] dp = new int[n][3];

            for(int j = 0; j < 3; j++){
                if(f == j){
                    dp[0][j] = arr[0][j];
                }else{
                    dp[0][j] = INF;
                }
            }

            for(int i = 1; i < n; i++){
                dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }

            for(int l = 0; l < 3; l++){
                if(l != f){
                    answer = Math.min(answer, dp[n-1][l]);
                }
            }
        }

        System.out.println(answer);
    }//main end
}//class end
