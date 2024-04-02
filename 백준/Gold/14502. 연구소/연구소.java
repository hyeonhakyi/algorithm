import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static class virus{
		int x;
		int y; 
		public virus(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int n,m,max;
	private static int[][] map;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0);
		System.out.println(max);
	}//main end
	
	private static void combi(int idx) {
		if(idx == 3) {
			check();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					combi(idx+1);
					map[i][j] = 0;
				}
			}
		}
	}//combi end
	
	private static void check() {
		Queue<virus> vir = new LinkedList<>();
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 2) {
					vir.offer(new virus(i, j));
				}
			}
		}
		
		int[][] copyMap = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		while(!vir.isEmpty()) {
			virus vi = vir.poll();
			int x = vi.x;
			int y = vi.y;
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m)continue;
				if(copyMap[nx][ny] == 0) {
					copyMap[nx][ny] = 2;
					vir.offer(new virus(nx, ny));
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(copyMap[i][j] == 0) {
					count++;
				}
			}
		}
		
		max = Math.max(count, max);
	}
}//class end

