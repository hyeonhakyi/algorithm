import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int oddCount = 0;
        int maxLen = 0;

        for(int right = 0; right < n; right++){
            if(arr[right] % 2 == 1) oddCount++;

            while(oddCount > k){
                if(arr[left] % 2 == 1) oddCount--;
                left++;
            }

            int winLen = right - left + 1;
            int totalLen = winLen - oddCount;
            maxLen = Math.max(maxLen, totalLen);
        }

        System.out.println(maxLen);
    }//main end
}//class end
