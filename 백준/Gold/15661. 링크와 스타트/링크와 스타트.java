import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] pick;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        pick = new boolean[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);
    }//main end

    private static void dfs(int idx){
        if(idx == n){
            int startCnt = 0;
            for(int i = 0; i < n; i++){
                if(pick[i]){
                    startCnt++;
                }
            }

            if(startCnt == 0 || startCnt == n) return;

            int start = 0;
            int link = 0;

            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    if(pick[i] && pick[j]){
                        start += (arr[i][j] + arr[j][i]);
                    }else if(!pick[i] && !pick[j]){
                        link += (arr[i][j] + arr[j][i]);
                    }
                }
            }

            answer = Math.min(answer, Math.abs(start - link));
            return;
        }

        pick[idx] = true;
        dfs(idx + 1);

        pick[idx] = false;
        dfs(idx + 1);
    }//dfs end
}//class end
