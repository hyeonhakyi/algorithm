import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class tresh{
        int x;
        int y;
        int value;
        public tresh(int x,int y,int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    private static int r,c,t,cleaner = -1;
    private static int[][] map;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static Queue<tresh> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == -1 && cleaner == -1){
                    cleaner = i;
                }
            }
        }

        for(int i = 0; i < t; i++){
            check();
            bfs();
            operate();
        }

        int count = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] != -1 && map[i][j] != 0){
                    count += map[i][j];
                }
            }
        }
        System.out.println(count);
    }//main end

    private static void check(){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] != -1 && map[i][j] != 0){
                    que.offer(new tresh(i,j,map[i][j]));
                }
            }
        }
    }

    private static void bfs(){
            while (!que.isEmpty()) {
                tresh now = que.poll();
                if (now.value < 5) continue;
                int spread = now.value / 5;
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if (map[nx][ny] != -1) {
                            map[nx][ny] += spread;
                            count++;
                        }
                    }
                }
                map[now.x][now.y] -= (spread * count);
            }
    }//bfs end

private static void operate() {

    int top = cleaner;
    int down = cleaner + 1;

    // 위쪽 공기청정기의 바람은 반시계방향 순환,
    // 아래로 당기기
    for (int i = top - 1; i > 0; i--)
        map[i][0] = map[i-1][0];
    // 왼쪽으로 당기기
    for (int i = 0; i < c - 1; i++)
        map[0][i] = map[0][i+1];
    // 위로 당기기
    for (int i = 0; i < top; i++)
        map[i][c - 1] = map[i + 1][c - 1];
    // 오른쪽으로 당기기
    for (int i = c - 1; i > 1; i--)
        map[top][i] = map[top][i-1];
    // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
    map[top][1] = 0;

    // 아래쪽 공기청정기의 바람은 시계방향으로 순환
    // 위로 당기기
    for (int i = down + 1; i < r - 1; i++)
        map[i][0] = map[i + 1][0];
    // 왼쪽으로 당기기
    for (int i = 0; i < c - 1; i++)
        map[r - 1][i] = map[r - 1][i + 1];
    // 아래로 당기기
    for (int i = r - 1; i > down; i--)
        map[i][c - 1] = map[i - 1][c - 1];
    // 오른쪽으로 당기기
    for (int i = c - 1; i > 1; i--)
        map[down][i] = map[down][i - 1];
    // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
    map[down][1] = 0;
}
}//class end
