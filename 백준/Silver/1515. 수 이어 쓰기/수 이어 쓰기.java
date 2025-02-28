
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int pt = 0; // 포인터
        int base = 0; //증가하는 자연수
        
        while(base++ <= 30000){
            String tmp = String.valueOf(base);
            for(int i = 0; i < tmp.length(); i++){
                if(tmp.charAt(i) == str.charAt(pt)){
                    pt++;
                }
                if(pt == str.length()){
                    System.out.println(base);
                    return;
                }
            }
        }
    }//main end
}//class end
