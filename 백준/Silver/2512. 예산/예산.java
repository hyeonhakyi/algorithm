import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int numMax = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            numMax = Math.max(numMax,num);
        }

        int max = Integer.parseInt(br.readLine());

        int left = 0;
        int right = numMax;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            int sum = 0;
            for(int i : arr){
                sum += Math.min(i,mid);
            }

            if(sum <= max){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }//main end
}//class end
