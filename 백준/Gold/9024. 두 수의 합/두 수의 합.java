import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int T = 0; T < t; T++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int left = 0;
            int right = n - 1;
            long bestDiff = Long.MAX_VALUE;
            long count = 0;
            while(left < right){
                long sum = (long) arr[left] + arr[right];
                long diff = Math.abs(sum - (long)k);

                if(diff < bestDiff){
                    bestDiff = diff;
                    count = 1;
                }else if(bestDiff == diff){
                    count++;
                }

                if(sum >= k){
                    right--;
                }else{
                    left++;
                }
            }

            System.out.println(count);
        }//testCase end
    }//main end
}//class end
