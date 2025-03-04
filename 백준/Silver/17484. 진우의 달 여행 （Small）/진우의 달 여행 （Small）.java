import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;
    static int[][][] dp;
    static int max = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        // 입력된 연료 소모량을 저장하는 배열
        int[][] grid = new int[h][w];

        // 현재 위치까지 가는데 소모되는 연료량을 저장하는 배열
        int[][][] dp = new int[h][w][3];

        // 입련된 연료 소모량을 먼저 배열에 저장합니다.
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < w; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp계산을 위해 0줄을 먼저 dp에 입력
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = grid[0][i];
            }
        }

        // dp 계산 시작.
        for (int i = 1; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 같은 방향이 아닌 다른 방향으로 오는 연료량들을 전부 다 계산하는 방식으로 접근.
                // 방향 : 0 → 왼쪽, 1 → 가운데, 2 → 오른쪽
                if (j == 0) { // 맨 왼쪽은 왼쪽이 없기 때문에 왼쪽에서 오는 방향은 이 문제의 최댓값인 600이 넘는 수를 할당.
                    dp[i][j][0] = 700;
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + grid[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + grid[i][j];
                } else if (j == w - 1) { // 맨 오른쪽은 오른쪽이 없기 때문에 동일하게 600이 넘는 값을 할당.
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + grid[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + grid[i][j];
                    dp[i][j][2] = 700;
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + grid[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + grid[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + grid[i][j];
                }
            }
        }

        // 계산된 마지막 줄의 연료량 중 가장 작은 연료량을 출력
        int min = 700;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[h - 1][i][j]);
            }
        }

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
        br.close();
    }//main end
}//class end
