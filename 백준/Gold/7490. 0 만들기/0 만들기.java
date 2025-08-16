import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int target;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            target = Integer.parseInt(br.readLine());
            sb = new StringBuilder();

            dfs(1,1,0,1,"1");
            System.out.println(sb);
        }


    }//main end

    static void dfs(int idx,int num,int sum,int op,String ex){
        if(idx == target){
            sum += (num*op);
            if(sum == 0){
                sb.append(ex+"\n");
            }
            return;
        }
        dfs(idx + 1, num * 10 + (idx + 1), sum, op, ex + " " + Integer.toString(idx + 1));
        dfs(idx +1, idx +1, sum + (num * op), 1, ex + "+"+ Integer.toString(idx + 1));
        dfs(idx + 1, idx + 1, sum + (num * op), -1, ex + "-" + Integer.toString(idx + 1));
    }
}//class end
