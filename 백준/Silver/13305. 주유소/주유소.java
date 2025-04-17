import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] km;
    static int[] money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        km = new int[n-1];
        money = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n-1; i++){
            km[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long min = money[0];

        for(int i = 0; i < n-1; i++){
            if(money[i] < min){
                min = money[i];
            }
            sum += min*km[i];
        }

        System.out.println(sum);
    }
}
