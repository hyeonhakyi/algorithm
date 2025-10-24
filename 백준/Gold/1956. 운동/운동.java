import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] dist = new int[v + 1 ][v + 1];
        for(int i = 1; i <= v; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }

        for(int k = 1; k <= v; k++){
            for(int i = 1; i <= v; i++){
                if(dist[i][k] == Integer.MAX_VALUE) continue;
                for(int j = 1; j <= v; j++){
                    if(dist[k][j] == Integer.MAX_VALUE) continue;

                    int nd = dist[i][k] + dist[k][j];
                    if(nd < dist[i][j]){
                        dist[i][j] = nd;
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= v; i++){
            for(int j = 1; j <= v; j++){
                if(i == j) continue;
                if(dist[i][j] < Integer.MAX_VALUE && dist[j][i] < Integer.MAX_VALUE){
                    answer = Math.min(answer, dist[i][j] + dist[j][i]);
                }
            }
        }
        
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }//main end
}//class end
