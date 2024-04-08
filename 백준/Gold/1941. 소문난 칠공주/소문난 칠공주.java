import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static class Node{
		int x;
		int y;
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static char[][] arr;
	private static int answer;
	private static boolean[] visited;
	private static int[] select = new int[7];
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		
		for(int i = 0; i < 5; i++) {
			String s = br.readLine();
			for(int j = 0; j < 5; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		
		dfs(0,0,0);
		System.out.println(answer);
	}//main end
	
	private static void dfs(int depth,int numY,int start) {
		if(numY >= 4) {
			return;
		}
		if(depth == 7) {
			visited = new boolean[7];
			bfs();
			return;
		}
		
		for(int i = start; i < 25; i++) {
			select[depth] = i;
			if(arr[i/5][i%5] == 'Y') {
				dfs(depth+1,numY+1,i+1);
			}else {
				dfs(depth+1,numY,i+1);
			}
		}
	}//dfs end
	
	private static void bfs() {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(select[0]/5, select[0]%5));
		visited[0] = true;
		
		int count = 1;
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				int ni = nx*5 + ny;
				
				if(check(nx, ny)) {
					for(int j = 0; j < 7; j++) {
						if(!visited[j] && select[j] == ni) {
							visited[j] = true;
							que.offer(new Node(nx, ny));
							count++;
						}
					}
				}
			}
		}
		if(count == 7)answer++;
	}//bfs end
	
	private static boolean check(int x,int y) {
		return x >= 0 && y >= 0 && x < 5 && y < 5;
	}
}//class end
