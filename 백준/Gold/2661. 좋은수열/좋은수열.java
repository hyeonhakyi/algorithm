import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean done;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs(new StringBuilder());

    }//main end

    private static void dfs(StringBuilder sb){
        if(done) return;
        if(!check(sb)) return;
        if(sb.length() == n){
            System.out.println(sb.toString());
            done = true;
            return;
        }

        for(char i = '1'; i <= '3'; i++){
            sb.append(i);
            dfs(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }//dfs end

    private static boolean check(StringBuilder sb){
        int len = sb.length();
        for(int k = 1; k * 2 <= len; k++){
            boolean same = true;

            for(int i = 0; i < k; i++){
                if (sb.charAt(len - 2 * k + i) != sb.charAt(len - k + i)) {
                    same = false;
                    break;
                }
            }

            if(same){
                return false;
            }
        }
        return true;
    }//check end
}//class end
