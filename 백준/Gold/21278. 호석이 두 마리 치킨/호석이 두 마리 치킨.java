import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    int nd = dist[j][i] + dist[i][k];
                    if(dist[j][k] > nd){
                        dist[j][k] = nd;
                    }
                }
            }
        }

        int maxSum = Integer.MAX_VALUE;
        int a = 1;
        int b = 2;
        for(int i = 1; i <= n; i++){
            for(int j = i + 1; j <= n; j++){
                int sum = 0;
                for(int x = 1; x <= n; x++){
                    int minX = Math.min(dist[x][i],dist[x][j]);
                    sum += 2 * minX;
                }

                if(sum < maxSum){
                    maxSum = sum;
                    a = i;
                    b = j;
                }
            }
        }

        System.out.println(a + " " + b + " " + maxSum);
    }//main end
}//class end
