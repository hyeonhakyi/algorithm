import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[20];

        for(int i = 0; i < n; i++){
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            int testNum = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 20; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int k = 0; k < 20; k++){
                for(int l = 0; l < k; l++){
                    if(arr[k] < arr[l]){
                        cnt++;
                    }
                }
            }
            System.out.println(testNum + " " + cnt);
        }
    }//main end
}//class end
