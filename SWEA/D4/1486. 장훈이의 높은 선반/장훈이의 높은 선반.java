import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static int n, b, result;
	private static int[] arr;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr = new int[n];
			visited = new boolean[n];
			result = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			dfs(0);
			System.out.println("#" + tc + " " + (result - b));
		} // testCase end
	}// main end

	private static void dfs(int idx) {
		if (check() > result) {
			return;
		}
		
		if (check() >= b) {
			result = check();
			return;
		}

		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i+1);
				visited[i] = false;
			}
		}
	}// dfs end

	private static int check() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				sum += arr[i];
			}
		}
		return sum;
	}// check end
}// class end
