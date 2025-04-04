import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] ch = str.toCharArray();

        int totalR = 0;
        int totalB = 0;
        int leftR = 0;
        int leftB = 0;
        int rightB = 0;
        int rightR = 0;

        for(int i = 0; i < n; i++) {
            if(ch[i] == 'R') {
                totalR++;
            }
            if(ch[i] == 'B') {
                totalB++;
            }
        }

        for(int i = 0; i < n; i++) {
            if(ch[i] == 'R') {
                leftR++;
            }else{
                break;
            }
        }

        for(int i = 0; i < n; i++) {
            if(ch[i] == 'B') {
                leftB++;
            }else{
                break;
            }
        }

        for(int i = n-1; i >= 0; i--) {
            if(ch[i] == 'R') {
                rightR++;
            }else{
                break;
            }
        }

        for(int i = n-1; i >= 0; i--) {
            if(ch[i] == 'B') {
                rightB++;
            }else{
                break;
            }
        }
        int answer = Integer.MAX_VALUE;

        answer = Math.min(answer,(totalR - leftR));
        answer = Math.min(answer,(totalB - rightB));
        answer = Math.min(answer,(totalR - rightR));
        answer = Math.min(answer,(totalB - leftB));

        System.out.println(answer);
    }//main end
}
