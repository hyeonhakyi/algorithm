import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String target = br.readLine();
        int bomSize = target.length();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));

            if(stack.size() >= bomSize){
                boolean check = true;
                for(int j = 0; j < bomSize; j++){
                    if(stack.get(stack.size() - bomSize + j) != target.charAt(j)){
                        check = false;
                        break;
                    }
                }

                if(check){
                    for(int j = 0; j < bomSize; j++){
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            for(char x : stack){
                sb.append(x);
            }
            System.out.println(sb.toString());
        }
    }//main end
}//class end
