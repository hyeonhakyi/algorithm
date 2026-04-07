import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int left = 0;
        int right = sum;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(canMake(mid)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }//main end

    private static boolean canMake(int target){
        int count = 0;
        int currentSum = 0;

        for(int i = 0; i < n; i++){
            currentSum += arr[i];

            if(currentSum >= target){
                count++;
                currentSum = 0;
            }
        }

        return count >= k;
    }//canMake end
}//class end
