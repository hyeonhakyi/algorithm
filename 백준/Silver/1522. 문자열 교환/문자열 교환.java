import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int aCount = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                aCount++;
            }
        }

        String dou = s + s;
        int minSwap = Integer.MAX_VALUE;
        int bCount = 0;

        for(int i = 0; i < aCount; i++) {
            if(dou.charAt(i) == 'b') {
                bCount++;
            }
        }

        minSwap = bCount;

        for(int i = aCount; i < dou.length(); i++) {
            if(dou.charAt(i - aCount) == 'b') {
                bCount--;
            }
            if(dou.charAt(i) == 'b') {
                bCount++;
            }
            
            minSwap = Math.min(minSwap,bCount);
        }

        System.out.println(minSwap);
    }//main end
}//class end
