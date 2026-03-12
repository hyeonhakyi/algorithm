import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s;
    static int L;
    static boolean[] used = new boolean[51];
    static int[] path = new int[51];
    static boolean done = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        L = s.length();
        dfs(0,0,0);
    }//main end

    private static void dfs(int idx,int cnt,int max){
        if(done) return;

        if(idx == L){
            if(max >= 1 && cnt == max){
                for(int i = 1; i <= max; i++){
                    if(!used[i]) return;
                }
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < cnt; i++){
                    if(i > 0){
                        sb.append(" ");
                    }
                    sb.append(path[i]);
                }
                System.out.println(sb);
                done = true;
            }
            return;
        }

        if(s.charAt(idx) == '0') return;

        int v1 = s.charAt(idx) - '0';
        if(v1 >= 1 && v1 <= 50 && !used[v1]){
            used[v1] = true;
            path[cnt] = v1;
            dfs(idx + 1, cnt + 1, Math.max(max, v1));
            used[v1] = false;
        }

        if(idx + 1 < L){
            int v2 = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
            if(v2 >= 10 && v2 <= 50 && !used[v2]){
                used[v2] = true;
                path[cnt] = v2;
                dfs(idx + 2,cnt + 1,Math.max(max,v2));
                used[v2] = false;
            }
        }
    }//dfs end
}//class end
