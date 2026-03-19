import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            char[] count = new char[26];
            for(int j = 0; j < str.length(); j++){
                count[str.charAt(j) - 'a']++;
            }

            char[] path = new char[str.length()];
            dfs(count,path,0,str.length());
        }

        System.out.println(sb);
    }//main end

    private static void dfs(char[] count,char[] path,int depth,int len){
        if(len == depth){
            sb.append(path).append("\n");
            return;
        }

        for(int i = 0; i < 26; i++){
            if(count[i] == 0) continue;

            count[i]--;
            path[depth] = (char) (i + 'a');

            dfs(count, path, depth + 1, len);

            count[i]++;
        }
    }//dfs end
}//class end
