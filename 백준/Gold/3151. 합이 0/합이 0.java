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
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = 0;

        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == 0){
                    if(arr[left] == arr[right]){
                        int cnt = right - left + 1;
                        answer += (long) cnt * (cnt - 1) / 2;
                        break;
                    }else{
                        int lv = arr[left];
                        int rv = arr[right];

                        int lcnt = 0;
                        while(left < right && arr[left] == lv){
                            lcnt++;
                            left++;
                        }

                        int rcnt = 0;
                        while(left <= right && arr[right] == rv){
                            rcnt++;
                            right--;
                        }

                        answer += (long) rcnt * lcnt;
                    }
                }else if (sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }

        System.out.println(answer);
    }//main end
}//class end
