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

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dist[s][e] = Math.min(dist[s][e],v);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(dist[j][i] == Integer.MAX_VALUE || dist[i][k] == Integer.MAX_VALUE) continue;
                    if(dist[j][i] + dist[i][k] < dist[j][k]){
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        int[] people = new int[k];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            int max = 0;
            boolean possible = true;

            for(int c : people){
                if(dist[c][i] == Integer.MAX_VALUE || dist[i][c] == Integer.MAX_VALUE){
                    possible = false;
                    break;
                }
                max = Math.max(max,dist[c][i] + dist[i][c]);
            }

            if(!possible) continue;

            if(max < min){
                min = max;
                sb.setLength(0);
                sb.append(i).append(" ");
            }else if(max == min){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }//main end
}//class end
