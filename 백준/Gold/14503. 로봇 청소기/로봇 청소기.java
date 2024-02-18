
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,r,c,d,count;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 1;
        dfs(r,c,d);
        System.out.println(count);
    }

    public static void dfs(int x, int y,int d){
        map[x][y] = -1;

        for(int k = 0; k < 4; k++){
            d = (d + 3) % 4;
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && map[nextX][nextY] == 0) {
                count++;
                dfs(nextX,nextY,d);

                return;
            }
        }

        int back = (d + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if(bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1){
            dfs(bx,by,d);
        }
    }
}
