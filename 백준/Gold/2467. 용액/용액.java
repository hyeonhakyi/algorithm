import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int answerLeft = 0;
        int answerRight = 0;
        int answer = Integer.MAX_VALUE;

        while (left < right) {
            int value = Math.abs(arr[left] + arr[right]);

            if(answer > value){
                answer = value;
                answerLeft = left;
                answerRight = right;
            }
            if(value == 0){
                break;
            }

            if(arr[right] + arr[left] > 0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(arr[answerLeft] + " " + arr[answerRight]);
    }//main end
}//class end
