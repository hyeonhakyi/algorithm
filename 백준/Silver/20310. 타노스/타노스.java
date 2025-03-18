
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;

        for(char c : s.toCharArray()) {
            sb.append(c);

            if(c == '0'){
                zeroCnt++;
            }else{
                oneCnt++;
            }
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '1'){
                sb.setCharAt(i, '2');
                oneCnt--;
            }
            if(oneCnt == 0){
                break;
            }
        }

        for(int i = sb.length() - 1; i > -1; i--) {
            if(sb.charAt(i) == '0'){
                sb.setCharAt(i,'2');
                zeroCnt--;
            }
            if(zeroCnt == 0){
                break;
            }
        }

        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '1' | sb.charAt(i) == '0'){
                System.out.print(sb.charAt(i));
            }
        }
    }//main end
}//class end
