import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n,ans,ans1;
    static String aStr,bStr;
    static int[] a;
    static int[] b;
    static int[] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        aStr = br.readLine();
        bStr = br.readLine();
        a = new int[n];
        b = new int[n];

        for(int i = 0; i < aStr.length(); i++){
            a[i] = aStr.charAt(i) - '0';
        }

        for(int i = 0; i < bStr.length(); i++){
            b[i] = bStr.charAt(i) - '0';
        }

        c = Arrays.copyOf(a,n);
        c[0] = 1 - c[0];
        c[1] = 1 - c[1];

        ans = result(n,a,b);
        ans1 = result(n,c,b);
        if(ans1 != -1)ans1++;

        if(ans == -1){
            System.out.println(ans1);
        }else if(ans1 == -1){
            System.out.println(ans);
        }else{
            System.out.println(Math.min(ans,ans1));
        }
    }

    public static int result(int n, int[] a, int[] b){
        int count = 0;

        for(int i = 0; i < n-1; i++){
            if(a[i] != b[i]){
                count++;
                a[i] = 1- a[i];
                a[i+1] = 1 - a[i+1];
                if(i != n-2){
                    a[i+2] = 1 - a[i+2];
                }
            }
        }
        if(a[n-1] != b[n-1]){
            return -1;
        }else {
            return count;
        }
    }
}
