import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n,count;
	static boolean[][] visited;
	static char[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i,j,arr[i][j]);
					count++;
				}
			}
		}
		System.out.print(count+" ");
		
		visited = new boolean[n][n];
		count = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 'R') {
					arr[i][j] = 'G';
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i,j,arr[i][j]);
					count++;
				}
			}
		}
		
		System.out.print(count);
	}
	
	
	private static void dfs(int x, int y,char cr) {
		visited[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= n || ny >=n)continue;
			if(arr[nx][ny] == cr && !visited[nx][ny]) {
				dfs(nx,ny,cr);
			}
		}
	}
	
	
	
	
	

}
