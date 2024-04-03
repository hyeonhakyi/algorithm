import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static class Shark {
		int x;
		int y;
		int speed;
		int dir;
		int size;

		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}

	private static int r, c, m, result;
	private static Shark[][] arr;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static Queue<Shark> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new Shark[r + 1][c + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());

			arr[x][y] = new Shark(x, y, speed, dir, size);
		}
		int idx = 0;
		while (idx != c) {
			idx++;
			catchShark(idx);
			check();
			moveShark();
		}

		System.out.println(result);
	}// main end

	private static void moveShark() {
		arr = new Shark[r + 1][c + 1];
		while (!que.isEmpty()) {
			Shark now = que.poll();
			for (int i = 0; i < now.speed; i++) {
				if (now.x == 1) {
					if (now.dir == 0) {
						now.dir = 1;
					}
				}
				if (now.x == r) {
					if (now.dir == 1) {
						now.dir = 0;
					}
				}
				if (now.y == 1) {
					if (now.dir == 3) {
						now.dir = 2;
					}
				}
				if (now.y == c) {
					if (now.dir == 2) {
						now.dir = 3;
					}
				}
				
				now.x += dx[now.dir];
				now.y += dy[now.dir];

				if (now.x == 1) {
					if (now.dir == 0) {
						now.dir = 1;
					}
				}
				if (now.x == r) {
					if (now.dir == 1) {
						now.dir = 0;
					}
				}
				if (now.y == 1) {
					if (now.dir == 3) {
						now.dir = 2;
					}
				}
				if (now.y == c) {
					if (now.dir == 2) {
						now.dir = 3;
					}
				}
			}

			if (arr[now.x][now.y] == null) {
				arr[now.x][now.y] = now;
			} else {
				if(arr[now.x][now.y].size<now.size) {
					arr[now.x][now.y]=now;
				}
			}
		}
	}// moveShark end

	private static void check() {
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (arr[i][j] != null) {
					que.offer(new Shark(i, j, arr[i][j].speed, arr[i][j].dir, arr[i][j].size));
				}
			}
		}
	}// check end

	private static void catchShark(int idx) {
		for (int i = 1; i <= r; i++) {
			if (arr[i][idx] != null) {
				result += arr[i][idx].size;
				arr[i][idx] = null;
				break;
			}
		}
	}// catchShark end

}// class end
