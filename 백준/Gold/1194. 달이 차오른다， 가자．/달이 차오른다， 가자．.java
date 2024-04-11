import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static class Node{
		int x;
		int y;
		int time;
		int key;
		public Node(int x,int y,int time,int key) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.key = key;
		}
	}
	private static int n,m,result = Integer.MAX_VALUE;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static char[][] arr;
	private static boolean[][][] visited;
	private static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		visited = new boolean[n][m][64];
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j);
				
				if(arr[i][j] == '0') {
					que.offer(new Node(i, j, 0, 0));
					visited[i][j][0] = true;
				}
			}
		}
		
		bfs();
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}//main end
	
	private static void bfs() {
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			if(arr[now.x][now.y] == '1') {
				result = now.time;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				
				if(!check(nx, ny))continue;
				if(arr[nx][ny] == '#')continue;
				if(visited[nx][ny][now.key])continue;
				
				
				if(arr[nx][ny] >= 'a' && arr[nx][ny] <= 'z') {
					int key = now.key | 1 << (arr[nx][ny] - 'a');
					que.offer(new Node(nx, ny, now.time+1, key));
					visited[nx][ny][key] = true;
				}else if(arr[nx][ny] >= 'A' && arr[nx][ny] <= 'Z') {
					boolean che = (now.key & 1 << (arr[nx][ny] - 'A')) != 0;
					if(che) {
						que.offer(new Node(nx, ny, now.time+1, now.key));
						visited[nx][ny][now.key] = true;
					}
				}else {
					que.offer(new Node(nx, ny, now.time+1, now.key));
					visited[nx][ny][now.key] = true;
				}
			}
		}
	}//bfs end
	
	private static boolean check(int x,int y) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}
}//class end
