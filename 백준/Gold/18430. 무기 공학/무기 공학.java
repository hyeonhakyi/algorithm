import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,answer;
    static int[][] arr;
    static int[] dx1 = {0,1,0,-1};
    static int[] dy1 = {-1,0,-1,0};
    static int[] dx2 = {-1,0,1,0};
    static int[] dy2 = {0,1,0,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(answer);
    }//main end

    private static void dfs(int idx, int sum) {
        if(idx == n * m){
            answer = Math.max(answer,sum);
            return;
        }

        int x = idx / m;
        int y = idx % m;

        if(!visited[x][y]){
            for(int d = 0; d < 4; d++){
                int nx1 = x + dx1[d];
                int nx2 = x + dx2[d];
                int ny1 = y + dy1[d];
                int ny2 = y + dy2[d];

                if(check(nx1,ny1) && check(nx2,ny2) && !visited[nx1][ny1] && !visited[nx2][ny2]){
                    visited[x][y] = true;
                    visited[nx1][ny1] = true;
                    visited[nx2][ny2] = true;

                    int add = arr[x][y] * 2 + arr[nx1][ny1] + arr[nx2][ny2];
                    dfs(idx + 1, sum + add);
                    visited[x][y] = false;
                    visited[nx1][ny1] = false;
                    visited[nx2][ny2] = false;
                }
            }
        }
        dfs(idx + 1,sum);
    }//dfs end

    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}//class end
