import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        double sum = 0;

        for(int i = 0; i < n; i++) {
            sum += (double) arr[i][0] * arr[(i + 1) % n][1];
            sum -= (double) arr[i][1] * arr[(i + 1) % n][0];
        }

        System.out.printf("%.1f",Math.abs(sum/2));
    }//main end
}//class end
