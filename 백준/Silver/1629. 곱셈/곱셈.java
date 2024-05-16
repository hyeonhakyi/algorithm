import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(cal(a,b,c));
    }//main end

    private static long cal(long a,long b,long c){
        if(b == 1){
            return a % c;
        }
        else{
            long half = cal(a,b/2,c);

            if(b%2  == 1){
                return (half * half % c) * a % c;
            }
            return half * half % c;
        }
    }//cal end
}//class end
