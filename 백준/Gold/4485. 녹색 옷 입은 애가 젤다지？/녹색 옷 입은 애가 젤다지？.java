import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static class Node implements Comparable<Node> {
		int x;
		int y;
		int value;

		public Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.value, o.value);
		}
	}

	private static int n, result;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) {
				break;
			}
			arr = new int[n][n];
			visited = new boolean[n][n];
			result = 0;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(0, 0);
			System.out.println("Problem "+ idx + ": " + result);
			idx++;
		}
	}// main end

	private static void bfs(int x, int y) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.offer(new Node(x, y, arr[x][y]));
		visited[x][y] = true;

		while (!que.isEmpty()) {
			Node now = que.poll();
			int nowX = now.x;
			int nowY = now.y;
			int value = now.value;

			if (nowX == n - 1 && nowY == n - 1) {
				result = value;
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nx = nowX + dx[d];
				int ny = nowY + dy[d];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
					visited[nx][ny] = true;
					que.offer(new Node(nx, ny, value + arr[nx][ny]));
				}
			}
		}
	}
}// call end
