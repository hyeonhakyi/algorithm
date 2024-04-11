import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static class Node implements Comparable<Node>{
		int x;
		int y;
		int time;
		public Node(int x,int y,int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}
	private static int n,m,sx,sy,ex,ey,min;
	private static char[][] arr;
	private static boolean[][] visited;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			String s = br.readLine();
			for(int j = 1; j <= m; j++) {
				arr[i][j] = s.charAt(j-1);
			}
		}
		
		bfs();
		System.out.println(min);
	}//main end
	
	private static void bfs() {
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.offer(new Node(sx, sy, 0));
		visited[sx][sy] = true;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			if(now.x == ex && now.y == ey) {
				min = now.time;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				
				
				if(!check(nx, ny))continue;
				if(visited[nx][ny])continue;
				visited[nx][ny] = true;
				
				if(arr[nx][ny] == '0') {
					que.offer(new Node(nx, ny, now.time));
				}else {
					que.offer(new Node(nx, ny, now.time+1));
				}
			}
		}
	}//bfs end
	
	private static boolean check(int x,int y) {
		return x >= 1 && y >= 1 && x <= n && y <= m;
	}
}//class end
