import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }


            long maxPrice = 0;
            long answer = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] > maxPrice) {
                    maxPrice = arr[j];
                } else {
                    answer += (maxPrice - arr[j]);
                }
            }
            
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }//main end
}//class end
