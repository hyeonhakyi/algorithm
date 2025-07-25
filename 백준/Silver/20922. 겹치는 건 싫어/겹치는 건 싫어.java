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
        int[] visited  = new int[100001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int answer = Integer.MIN_VALUE;
        while(right < n){
            while(right < n && visited[arr[right]] + 1 <= k){
                visited[arr[right++]]++;
            }

            int len = right - left;
            answer = Math.max(answer, len);
            visited[arr[left++]]--;
        }

        System.out.println(answer);
    }//main end
}//class end
