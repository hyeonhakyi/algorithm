import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());

        int left = 0;
        int right = maxValue;
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            long total = 0;
            for(int r : arr){
                total += Math.min(r,mid);
            }

            if(total <= m){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }//main end
}//class end
