import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int mid = (n+1)/2;

        boolean[][] check = new boolean[n + 1][n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[a][b] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(!check[j][i]) continue;
                for(int k = 1; k <= n; k++){
                    if(check[i][k]) check[j][k] = true;
                }
            }
        }

        int answer = 0;

        for(int i = 1; i <= n; i++){
            int heavier = 0;
            int lower = 0;

            for(int j = 1; j <= n; j++){
                if(check[i][j]) lower++;
                if(check[j][i]) heavier++;
            }

            if(heavier >= mid || lower >= mid) answer++;
        }

        System.out.println(answer);
    }//main end
}//class end
