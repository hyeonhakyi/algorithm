import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int d, w, k, result;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[d][w];
			result = Integer.MAX_VALUE;

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, 0);

			System.out.println("#" + tc + " " + result);
		} // testCase end
	}// main end

	private static boolean check(int[][] arr) {
		int count = 0;
		boolean che = false;
		for (int i = 0; i < w; i++) {
			che = false;
			count = 1;
			for (int j = 0; j < d - 1; j++) {
				if (arr[j][i] == arr[j + 1][i]) {
					count += 1;
				} else {
					count = 1;
				}
				if (count >= k) {
					che = true;
					break;
				}
			}
			if(che==false) {
				return false;
			}
		}
		return che;
	}// check end

	private static void dfs(int idx, int count) {
		if (idx == d) {
			if (check(arr)) {
				result = Math.min(count, result);
				return;
			}
			return;
		}
		int[] tmp = new int[w];
		for(int i = 0; i < w; i++) {
			tmp[i] = arr[idx][i];
		}
		dfs(idx + 1, count);

		for (int j = 0; j < w; j++) {
			arr[idx][j] = 0;
		}
		dfs(idx + 1, count + 1);
		arr[idx] = tmp;
		
		tmp = new int[w];
		for(int i = 0; i < w; i++) {
			tmp[i] = arr[idx][i];
		}
		for (int j = 0; j < w; j++) {
			arr[idx][j] = 1;
		}
		dfs(idx + 1, count + 1);
		arr[idx] = tmp;
	}// dfs
}// class end
