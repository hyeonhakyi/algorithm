import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = str.charAt(i) - '0';
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int num = arr[i];

            while(!stack.isEmpty() && stack.peek() < num && k > 0){
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : stack){
            sb.append(i);
        }

        System.out.println(sb);
    }//main end
}//class end
