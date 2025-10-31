import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] ax = new int[n];
        int[] ay = new int[n];
        
        int[] cntX = new int[100001];
        int[] cntY = new int[100001];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ax[i] = x;
            ay[i] = y;
            cntX[x]++;
            cntY[y]++;
        }

        long ans = 0;
        for(int i = 0; i < n; i++){
            long x = cntX[ax[i]] - 1;
            long y = cntY[ay[i]] - 1;
            
            if(x > 0 && y > 0){
                ans += x * y;
            }
        }

        System.out.println(ans);
    }//main end
}//class end
