import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, count = 0;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[1][1] = true;
        dfs(1, 2, 0);
        System.out.println(count);
    }

    static void dfs(int x, int y, int direction) {
        if (x == n && y == n) {
            count++;
            return;
        }

        if (direction == 0 || direction == 1) { // 가로 or 대각선 방향으로 이동하는 경우
            if (isValid(x, y + 1) && arr[x][y + 1] == 0) {
                dfs(x, y + 1, 0); // 가로 방향으로 이동
            }
        }
        if (direction == 1 || direction == 2) { // 대각선 or 세로 방향으로 이동하는 경우
            if (isValid(x + 1, y) && arr[x + 1][y] == 0) {
                dfs(x + 1, y, 2); // 세로 방향으로 이동
            }
        }
        if (isValid(x + 1, y + 1) && arr[x + 1][y] == 0 && arr[x][y + 1] == 0 && arr[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 1); // 대각선 방향으로 이동
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n && !visited[x][y];
    }
}