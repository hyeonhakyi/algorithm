import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m,l;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[n + 2];
        arr[0] = 0;
        arr[n + 1] = l;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = l;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;

            for(int i = 1; i < arr.length; i++){
                int num = arr[i] - arr[i - 1];
                count += (num - 1) / mid;
            }

            if(count <= m){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }//main end
}//class end
