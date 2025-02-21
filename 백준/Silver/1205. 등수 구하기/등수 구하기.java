import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        if(n == 0){
            System.out.println(1);
            return;
        }
        
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int lank = 1;
        for(int i = 0; i < n; i++){
            if(list[i] > newScore){
                lank++;
            } else if(list[i] < newScore){
                break;
            }
            cnt++;
        }
        if(cnt == p && list[n-1] >= newScore){
            System.out.println(-1);
        }else{
            System.out.println(lank);
        }

    }//main end
}//class end
