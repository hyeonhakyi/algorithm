import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int n,l,r,diff;
    private static boolean isMmove;
    private static int[][] arr;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean[][] visited;
    private static ArrayList<Pair> list = new ArrayList<>();
    private static int dayCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            isMmove = false;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if(!isMmove)break;
            else dayCnt++;
        }
        System.out.println(dayCnt);
    }

    public static void bfs(int x,int y) {
        Queue<int[]> que = new LinkedList<>();
        list.add(new Pair(x,y));
        que.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!que.isEmpty()) {
            int now[] = que.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny]) {
                        diff = Math.abs(arr[nowX][nowY] - arr[nx][ny]);
                        if (l <= diff && diff <= r) {
                            isMmove = true;
                            visited[nx][ny] = true;
                            list.add(new Pair(nx,ny));
                            que.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        calculation();
    }

    public static void calculation(){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
           Pair p = list.get(i);
           sum += arr[p.x][p.y];
        }
        for(int i = 0; i < list.size(); i++){
            Pair p = list.get(i);
            arr[p.x][p.y] = sum/list.size();
        }
        list.removeAll(list);
    }
}
