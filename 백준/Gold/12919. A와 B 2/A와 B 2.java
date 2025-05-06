import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s,t;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        len = t.length();

        int answer = dfs(s,t);
        System.out.println(answer);
    }//main end

    private static int dfs(String s,String t) {
        if(s.length() == t.length()) {
            if(s.equals(t)){
                return 1;
            }
            return 0;
        }
        
        int ans = 0;
        if(t.charAt(0) == 'B'){
            String str = t.substring(1);
            StringBuilder  sb = new StringBuilder(str);
            String string = sb.reverse().toString();
            ans += dfs(s,string);
        }
        
        if(t.charAt(t.length() - 1) == 'A'){
            ans += dfs(s,t.substring(0,t.length()-1));
        }
        
        return ans > 0 ? 1 : 0;
    }//dfs end
}//class end
