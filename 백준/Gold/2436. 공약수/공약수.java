import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long gcd = Long.parseLong(st.nextToken());
        long lcm = Long.parseLong(st.nextToken());

        long target = lcm / gcd;

        long a = 1;
        long b = target;

        for(long i = 1; i * i <= target; i++){
            if(target % i != 0) continue;

            long j = target / i;

            if(gcd(i, j) == 1){
                a = i;
                b = j;
            }
        }

        System.out.println((gcd * a) + " " + (gcd * b));
    }//main end

    private static long gcd(long x,long y){
        while(y != 0){
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}//class end
