import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    private static int n,m,r,c,l,max;
    private static int[] dx = {-1,0,1,0};//상 우 하 좌
    private static int[] dy = {0,1,0,-1};
    private static int[][] terminal = {
            {0,0,0,0},
            {1,1,1,1},
            {1,0,1,0},
            {0,1,0,1},
            {1,1,0,0},
            {0,1,1,0},
            {0,0,1,1},
            {1,0,0,1}
    };
    private static int[][] arr;
    private static boolean[][] visited;
    private static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            visited = new boolean[n][m];
            check = new boolean[n][m];
            max = 0;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(r,c,1);

            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(check[i][j]){
                        max++;
                    }
                }
            }

                System.out.println("#" + tc + " " + max);
        }//test_case end


    }//main end

    private static void dfs(int x,int y,int time){
        check[x][y] = true;
        if(time == l){
            return;
        }

        int[] dir = terminal[arr[x][y]];
        for(int d = 0; d < 4; d++){
            if(dir[d] == 0)continue;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(visited[nx][ny])continue;
            if(arr[nx][ny] == 0)continue;

            if(terminal[arr[nx][ny]][(d+2)%4] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny, time + 1);
                visited[nx][ny] = false;
            }
        }
    }
}//class end
