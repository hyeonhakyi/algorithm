import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] position;
	private static int m, n, l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		position = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			position[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (check(x, y)) {
				count++;
			}
		}

		System.out.println(count);
	}// main end

	private static boolean check(int x, int y) {
		for (int i = 0; i < m; i++) {
			int diff = Math.abs(position[i] - x) + y;

			if (diff <= l) {
				return true;
			}
		}
		return false;
	}// check end
}// class end
