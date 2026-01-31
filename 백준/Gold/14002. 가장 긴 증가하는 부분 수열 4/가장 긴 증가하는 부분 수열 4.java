import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(prev, -1);

        int maxLen = 0;
        int lastIdx = 0;

        for(int i = 0; i < n; i++){
            dp[i] = 1;

            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if(dp[i] > maxLen){
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxLen).append("\n");

        Stack<Integer> stack = new Stack<>();
        while(lastIdx != -1){
            stack.push(arr[lastIdx]);
            lastIdx = prev[lastIdx];
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }//main end
}//class end
