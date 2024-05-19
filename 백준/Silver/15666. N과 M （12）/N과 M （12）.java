import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[] arr;
    private static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        per(0,0);
    }//main end

    private static void per(int count,int start){
        if(count == m){
            for(int i = 0; i < m; i++){
                System.out.print(answer[i]+" ");
            }
            System.out.println();
            return;
        }

        int befor = -1;
        for(int i = start; i < n; i++){
            int now = arr[i];
            if(befor != now){
                befor = now;
                answer[count] = arr[i];
                per(count+1,i);
            }
        }
    }//per end
}//class end
