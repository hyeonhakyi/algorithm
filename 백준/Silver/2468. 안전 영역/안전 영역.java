
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static int[][] map;
    static boolean[][] checked;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0,- 1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int maxHeight = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight,map[i][j]);
            }
        }
        int max = 0;
        for(int height = 0; height < maxHeight + 1; height++){
            checked = new boolean[n][n];
            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j <n; j++){
                    if(map[i][j] > height && !checked[i][j]){
                        cnt += dfs(i,j,height);
                    }
                }
            }
            max = Math.max(max,cnt);
        }

        System.out.println(max);
    }

    public static int dfs(int x, int y, int height){
        checked[x][y] = true;

        for(int d = 0; d < 4; d++){
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
            if(map[nextX][nextY] > height && !checked[nextX][nextY]){
                dfs(nextX,nextY,height);
            }
        }
        return 1;
    }
}
