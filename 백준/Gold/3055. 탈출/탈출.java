import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	private static class Node{
		int x;
		int y;
		int time;
		public Node(int x,int y,int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	private static class Water{
		int x;
		int y;
		public Water(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static int r,c,result = 0;
	private static char[][] arr;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static Queue<Water> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		int startX = 0;
		int startY = 0;
		
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				arr[i][j] = s.charAt(j);
				
				if(arr[i][j] == 'S') {
					startX = i;
					startY = j;
				}else if(arr[i][j] == '*') {
					q.offer(new Water(i, j));
				}
			}
		}
		
		bfs(startX,startY);
		if(result == 0) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(result);
		}
		
		
	}//main end
	
	private static void bfs(int x,int y) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(x, y, 0));
		
		while(!que.isEmpty()) {
			int len = q.size();
			for(int i = 0; i < len; i++) { //물 먼저 실행
				Water water = q.poll();
				
				for(int d = 0; d < 4; d++) {
					int waterX = water.x + dx[d];
					int waterY = water.y + dy[d];
					
					if(waterX >= 0 && waterY >= 0 && waterX < r && waterY < c && arr[waterX][waterY] == '.') {
						q.offer(new Water(waterX, waterY));
						arr[waterX][waterY] = '*';
					}	
				}
			}
			
			int len1 = que.size();
			for(int i = 0; i < len1; i++) {
				Node now = que.poll();
				
				for(int j = 0; j < 4; j++) {
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];
					
					if(nx >= 0 && ny >= 0 && nx < r && ny < c && arr[nx][ny] != '*' && arr[nx][ny] != 'X') {
						if(arr[nx][ny] == 'D') {
							result = now.time+1;
							return;
						}else if(arr[nx][ny] == '.') {
							arr[nx][ny] = 'S';
							que.offer(new Node(nx, ny, now.time+1));
						}
					}
				}
			}
		}
	}//bfs end
	
}//class end
