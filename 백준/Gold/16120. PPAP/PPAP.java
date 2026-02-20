import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] stack = new char[s.length()];
        int top = 0;
        for(int i = 0; i < s.length(); i++){
            stack[top++] = s.charAt(i);

            if(top >= 4 && stack[top - 1] == 'P'
                        && stack[top - 2] =='A'
                        && stack[top - 3] == 'P'
                        && stack[top - 4] == 'P'){
                top -= 3;

            }
        }

        if(top == 1 && stack[0] == 'P'){
            System.out.println("PPAP");
        }else{
            System.out.println("NP");
        }
    }//main end
}//class end
