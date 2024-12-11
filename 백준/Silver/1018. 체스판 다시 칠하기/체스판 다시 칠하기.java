import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                answer = Math.min(answer, Math.min(startWhite(i, j), startBlack(i, j)));
            }
        }
        System.out.println(answer);


    }//main end

    static int startWhite(int x, int y) {
        int sum = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (arr[i][j] != 'W') {
                        sum++;
                    }
                } else if (i % 2 != 0 && j % 2 == 0) {
                    if (arr[i][j] != 'B') {
                        sum++;
                    }
                } else if (i % 2 == 0 && j % 2 != 0) {
                    if (arr[i][j] != 'B') {
                        sum++;
                    }
                } else {
                    if (arr[i][j] != 'W') {
                        sum++;
                    }
                }
            }
        }

        return sum;
    }

    static int startBlack(int x, int y) {
        int sum = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (arr[i][j] != 'B') {
                        sum++;
                    }
                } else if (i % 2 != 0 && j % 2 == 0) {
                    if (arr[i][j] != 'W') {
                        sum++;
                    }
                } else if (i % 2 == 0 && j % 2 != 0) {
                    if (arr[i][j] != 'W') {
                        sum++;
                    }
                } else {
                    if (arr[i][j] != 'B') {
                        sum++;
                    }
                }
            }
        }

        return sum;
    }
}//class end
