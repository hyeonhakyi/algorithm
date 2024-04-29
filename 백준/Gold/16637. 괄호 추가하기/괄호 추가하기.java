import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static int result = Integer.MIN_VALUE;
    private static ArrayList<Integer> nums = new ArrayList<>();
    private static ArrayList<Character> operator = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for(int i = 0; i < n; i++){
            if(i%2==0){
                nums.add(str.charAt(i) - '0');
            }else{
                operator.add(str.charAt(i));
            }
        }
        dfs(0,nums.get(0));
        System.out.println(result);
    }//main end

    private static void dfs(int idx,int total){
        if(idx == operator.size()){
            result = Math.max(result,total);
            return;
        }

        int cal = calculate(total,nums.get(idx+1),operator.get(idx));
        dfs(idx + 1, cal);

        if(idx + 2 <= nums.size() - 1){
            cal = calculate(total, calculate(nums.get(idx + 1), nums.get(idx + 2), operator.get(idx + 1)), operator.get(idx));
            dfs(idx + 2, cal);
        }
    }//dfs end

    private static int calculate(int a, int b,char op){
        if(op == '+'){
            return a+b;
        }else if(op == '-'){
            return a - b;
        }else{
            return a * b;
        }
    }//cal end
}//class end
