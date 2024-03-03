import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int n,height;
    private static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            tree = new int[n];
            height = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                tree[i] = Integer.parseInt(st.nextToken());

                height = Math.max(height,tree[i]);
            }

            int one = 0;
            int two = 0;
            for(int i = 0; i < n; i++){
                int diff = height - tree[i];

                if(diff == 0) continue;

                one += diff/2;
                two += diff%2;
            }

            if(one > two){
                while(Math.abs(one - two) > 1) {
                    one--;
                    two += 2;
                }
            }
            int result = 0;
            if(two > one){
                result = two*2 -1;
            }else if(one > two){
                result = one*2;
            }else{
                result = one + two;
            }
            System.out.println("#" + tc + " " + result);
        }//test_case end
    }//main end
}//class end
