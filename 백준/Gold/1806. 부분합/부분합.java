import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while(true){
            if(sum >= s){
                sum -= arr[left];
                answer = Math.min(answer, right - left);
                left++;
            } else if (right == n) {
                break;
            }else {
                sum += arr[right];
                right++;
            }
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(answer);
        }
    }//main end
}//class end
