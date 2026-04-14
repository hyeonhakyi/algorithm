import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            String str = br.readLine();

            ArrayDeque<Character> left = new ArrayDeque<>();
            ArrayDeque<Character> right = new ArrayDeque<>();

            for(int j = 0; j < str.length(); j++){
                char chr = str.charAt(j);

                if(chr == '<'){
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                }else if(chr == '>'){
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                }else if(chr == '-'){
                    if(!left.isEmpty()){
                        left.pop();
                    }
                }else{
                    left.push(chr);
                }
            }
            StringBuilder temp = new StringBuilder();

            while(!left.isEmpty()){
                temp.append(left.removeLast());
            }

            while(!right.isEmpty()){
                temp.append(right.pop());
            }

            sb.append(temp).append("\n");
        }
        System.out.println(sb.toString());
    }//main end
}//class end
