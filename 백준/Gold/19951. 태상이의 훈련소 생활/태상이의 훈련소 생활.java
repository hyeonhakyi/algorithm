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
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dist = new int[n + 2];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            dist[a] += c;
            dist[b+1] -= c;
        }

        for (int i = 1; i <= n; i++) {
            dist[i] += dist[i - 1];
        }

        for(int i = 1; i <= n; i++){
            arr[i] += dist[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());
    }//main end
}//class end
