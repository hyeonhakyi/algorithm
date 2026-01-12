import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        Long[] answer = new Long[3];

        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;


            while(left < right){
                long sum = arr[i] + arr[left] + arr[right];

                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                if(sum > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        Arrays.sort(answer);

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }//main end
}//class end
