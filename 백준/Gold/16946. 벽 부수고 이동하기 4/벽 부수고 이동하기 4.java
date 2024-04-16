import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int n, m;
	private static int[][] arr;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int[][] visited;
	private static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && visited[i][j] == 0) {
					idx++;
					bfs(i, j, idx);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					int value = 1;
					Set<Integer> set = new HashSet<>();
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (!check(nx, ny)) {
							continue;
						}
						if (visited[nx][ny] == 0) {
							continue;
						}
						set.add(visited[nx][ny]);
					}
					for (int key : set) {
						value += map.get(key);
					}
					sb.append(value%10);
				}else {
					sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}// main end

	private static void bfs(int x, int y, int idx) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(x, y));
		visited[x][y] = idx;
		int count = 0;

		while (!que.isEmpty()) {
			Node now = que.poll();
			count++;
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if (!check(nx, ny)) {
					continue;
				}
				if (arr[nx][ny] != 0) {
					continue;
				}
				if (visited[nx][ny] != 0) {
					continue;
				}
				que.offer(new Node(nx, ny));
				visited[nx][ny] = idx;
			}
		}
		map.put(idx, count);
	}// bfs end

	private static void result(int x, int y) {
		int value = 1;
		Set<Integer> set = new HashSet<>();
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (!check(nx, ny)) {
				continue;
			}
			if (visited[nx][ny] == 0) {
				continue;
			}
			set.add(visited[nx][ny]);
		}
		for (int key : set) {
			value += map.get(key);
		}
		arr[x][y] = value;
	}// result end

	private static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}
}// class end
