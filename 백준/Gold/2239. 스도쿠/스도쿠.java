import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	private static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int[][] arr = new int[9][9];
	private static ArrayList<Node> list = new ArrayList<>();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = s.charAt(j) - '0';

				if (arr[i][j] == 0) {
					list.add(new Node(i, j));
				}
			}
		}

		dfs(0);
		
	}// main end

	private static void dfs(int count) {
		if (list.size() == count) {
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}

		boolean[] check = new boolean[10];
		
		Node now = list.get(count);
		int x = now.x;
		int y = now.y;

		
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] != 0) {
				check[arr[x][i]] = true;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (arr[i][y] != 0) {
				check[arr[i][y]] = true;
			}
		}

		int rx = (x / 3) * 3;
		int ry = (y / 3) * 3;
		for (int i = rx; i < rx + 3; i++) {
			for (int j = ry; j < ry + 3; j++) {
				if (arr[i][j] != 0) {
					check[arr[i][j]] = true;
				}
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (!check[i]) {
				arr[x][y] = i;
				dfs(count + 1);
				arr[x][y] = 0;
			}
		}
	}// dfs end
}// class end
