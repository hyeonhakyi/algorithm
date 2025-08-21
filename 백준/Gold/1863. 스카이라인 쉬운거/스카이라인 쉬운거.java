import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();


        int answer = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
                answer++;
            }

            if(stack.isEmpty() || stack.peek() < height){
                if(height != 0){
                    stack.push(height);
                }
            }
        }


        while(!stack.isEmpty()){
            stack.pop();
            answer++;
        }

        System.out.println(answer);
    }//main end
}//class end
