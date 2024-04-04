import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int result = Integer.MAX_VALUE;
	private static int[][] arr = new int[10][10];
	private static int[] answer = { 0, 5, 5, 5, 5, 5 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}// main end

	private static void dfs(int x, int y, int count) {
		if (x == 9 && y == 10) {
			result = Math.min(result, count);
			return;
		}

		if (y == 10) {
			dfs(x + 1, 0, count);
			return;
		}

		if (count >= result) {
			return;
		}

		if (arr[x][y] == 1) {
			for (int i = 5; i > 0; i--) {
				if (check(x, y, i) && answer[i] > 0) {
					answer[i]--;
					atach(x, y, i);
					dfs(x, y + 1, count + 1);
					detach(x, y, i);
					answer[i]++;
				}
			}
		} else {
			dfs(x, y + 1, count);
		}
	}// dfs end

	private static void atach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = 2;
			}
		}
	}// attach end

	private static void detach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = 1;
			}
		}
	}// detach end

	private static boolean check(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i >= 10 || j >= 10) {
					return false;
				}
				if (arr[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}// check end

}// class end
