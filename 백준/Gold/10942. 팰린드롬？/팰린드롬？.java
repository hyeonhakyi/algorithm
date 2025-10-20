import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n+1][n+1];

        for(int i = 1; i <= n; i++){
            int l = i, r = i;
            while(l >= 1 && r <= n && arr[l] == arr[r]){
                dp[l][r] = true;
                l--;
                r++;
            }
        }

        for(int i =1 ; i < n; i++){
            int l = i, r = i + 1;
            while(l >= 1 && r <= n && arr[l] == arr[r]){
                dp[l][r] = true;
                l--;
                r++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if(dp[s][t]){
                sb.append("1").append("\n");
            }else{
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb.toString());
    }//main end
}//class end
