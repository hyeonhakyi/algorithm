import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static int n, m, result, h, w, sx, sy, ex, ey;
    private static int[][] arr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        result = -1;
        bfs();
        System.out.println(result);
    }//main end

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy, 0));
        boolean[][] visited = new boolean[n + 1][m + 1];
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == ex && now.y == ey) {
                result = now.count;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!check(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (!innerCheck(nx, ny)) continue;

                q.offer(new Node(nx, ny, now.count + 1));
                visited[nx][ny] = true;
            }
        }
    }//bfs end

    public static boolean innerCheck(int x, int y) {
        for (int i = x; i < x + h; i++) {
            for (int j = y; j < y + w; j++) {
                if (i < 1 || j < 1 || i > n || j > m || arr[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    private static boolean check(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= m;
    }
}//class end
