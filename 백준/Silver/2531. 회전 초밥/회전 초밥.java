import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] check = new int[d+1];
        int kind = 0;
        
        for (int i = 0; i < k; i++) {
            if(check[arr[i]] == 0) {
                kind++;
            }
            check[arr[i]]++;
        }

        int max = kind;
        if(check[c] == 0) max++;

        for(int i = 1; i < n; i++){
            int out = arr[i - 1];
            check[out]--;
            if(check[out] == 0) kind--;

            int in = arr[(i + k - 1) % n];
            if(check[in] == 0) kind++;
            check[in]++;

            int tmpMax = kind;
            if(check[c] == 0) tmpMax++;

            max = Math.max(tmpMax, max);
        }
        System.out.println(max);
    }//main end
}//class end
