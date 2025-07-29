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
        int[] check = new int[d+1];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int kind = 1;
        check[c]++;
        for(int i = 0; i < k; i++){
            if(check[arr[i]] == 0){
                kind++;
            }
            check[arr[i]]++;
        }

        int count = kind;
        for(int i = 1; i < n; i++){
            int out = arr[i-1];
            check[out]--;
            if(check[out] == 0){
                count--;
            }

            int in = arr[(i + k - 1) % n];
            if(check[in] == 0){
                count++;
            }
            check[in]++;

            kind = Math.max(kind, count);
        }

        System.out.println(kind);
    }//main end
}//class end
