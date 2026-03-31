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
        for(int i = 0; i < n; i++){
            String name = br.readLine();
            arr[i] = name.length();
        }

        int[] count = new int[21];
        long answer = 0;
        for(int i = 0; i < n; i++){
            if(i > k){
                count[arr[i - k - 1]]--;
            }

            int len = arr[i];
            answer += count[len];
            count[len]++;
        }

        System.out.println(answer);
    }//main end
}//class end
