import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static class Node{
		int x;
		int y;
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static int n, m, count;
	private static char[][] arr;
	private static boolean[][] visited;
	private static ArrayList<Node> list = new ArrayList<>();
	private static int[][] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		visited = new boolean[n][m];
		result = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				list = new ArrayList<>();
				visited[i][j] = true;
				list.add(new Node(i, j));
				dfs(i, j, arr[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(count);
	}// main end

	private static void dfs(int x, int y, char dir) {
		int nx = 0;
		int ny = 0;

		if (dir == 'D') {
			nx = x + 1;
			ny = y;
		} else if (dir == 'U') {
			nx = x - 1;
			ny = y;
		} else if (dir == 'L') {
			nx = x;
			ny = y - 1;
		} else {
			nx = x;
			ny = y + 1;
		}

		if (!check(nx, ny)) {
			count++;
			cal(1);
			return;
		}
		
		if(result[nx][ny] == 1) {
			count++;
            cal(1);
			return;
		}else if(result[nx][ny] == 2) {
            cal(2);
			return;
		}
	
		if (!visited[nx][ny]) {
			visited[nx][ny] = true;
			list.add(new Node(nx, ny));
			dfs(nx, ny, arr[nx][ny]);
			visited[nx][ny] = false;
		} else {
			cal(2);
			return;
		}
	}// dfs end
	
	private static void cal(int value) {
		if(value == 1) {
			for(int i = 0; i < list.size(); i++) {
				Node now = list.get(i);
				
				result[now.x][now.y] = 1;
			}
		}else if(value == 2) {
			for(int i = 0; i < list.size(); i++) {
				Node now = list.get(i);
				
				result[now.x][now.y] = 2;
			}
		}
	}//cal end

	private static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}// check end
}// class end
