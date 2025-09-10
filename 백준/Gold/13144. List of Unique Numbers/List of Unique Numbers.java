import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int[] cnt = new int[100001];

        long answer = 0;
        
        int r = 0;
        for(int l = 0; l < n; l++) {
            while(r < n  && cnt[arr[r]] == 0){
                cnt[arr[r]]++;
                r++;
            }

            answer += (r - l);

            cnt[arr[l]]--;
        }
        System.out.println(answer);
    }//main end
}//class end
