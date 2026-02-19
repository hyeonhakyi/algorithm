import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Long> stack = new Stack<>();
        long answer = 0;

        for(int i = 0; i < n; i++){
            long h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= h){
                stack.pop();
            }

            answer += stack.size();

            stack.push(h);
        }

        System.out.println(answer);
    }//main end
}//class end
