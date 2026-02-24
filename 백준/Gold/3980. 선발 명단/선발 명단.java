import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(c --> 0){
            arr = new int[11][11];

            for(int i = 0; i < 11; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 11; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[11];
            answer = 0;
            dfs(0,0);

            sb.append(answer).append("\n");
        }//testCase end

        System.out.println(sb);
    }//main end

    private static void dfs(int idx,int sum){
        if(idx == 11){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < 11; i++){
            if(visited[i]) continue;
            if(arr[i][idx] == 0) continue;

            visited[i] = true;
            dfs(idx + 1, sum + arr[i][idx]);
            visited[i] = false;
        }
    }//dfs end
}//class end
