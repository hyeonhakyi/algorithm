
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        int[][] dp = new int[b.length() + 1][a.length() + 1];

        char[] Arr = new char[a.length()+1];
        char[] Brr = new char[b.length()+1];

        for(int i = 1; i <= a.length(); i++) {
            Arr[i] = a.charAt(i - 1);
        }

        for(int i = 1; i <= b.length(); i++) {
            Brr[i] = b.charAt(i - 1);
        }

        for(int i = 1; i <= b.length(); i++){
            for(int j = 1; j <= a.length(); j++){
                if(Brr[i] == Arr[j]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[b.length()][a.length()]);
    }//main end
}//class end
