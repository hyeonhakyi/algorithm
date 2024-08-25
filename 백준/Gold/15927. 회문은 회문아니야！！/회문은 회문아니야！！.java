
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int length = s.length();
        boolean check = false;
        for(int i = 0; i < length/2; i++){
            if(s.charAt(i) != s.charAt(length-i-1)){
                System.out.println(length);
                return;
            }else if(s.charAt(i) != s.charAt(i+1)){
                check = true;
            }
        }
        if(check){
            System.out.println(length-1);
        }else{
            System.out.println(-1);
        }
    }//main end
}//class end
