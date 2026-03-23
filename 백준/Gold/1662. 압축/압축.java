import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        idx = 0;

        System.out.println(getLength());
    }//main end

    private static int getLength() {
        int len = 0;

        while(idx < s.length()){
            char now = s.charAt(idx);

            if(now == ')'){
                idx++;
                return len;
            }

            if(idx + 1 < s.length() && s.charAt(idx + 1) == '('){
                int k = now - '0';
                idx += 2;
                len += k * getLength();
            }else{
                len++;
                idx++;
            }
        }
        return len;
    }//getLength() end
}//class end
