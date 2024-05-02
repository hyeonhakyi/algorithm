import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r,c,count;
	static char[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < r; i++) {
			if(DFS(i,0)) {
				count++;
			}
		}
		System.out.println(count);
	}
	public static boolean DFS(int x,int y) {
		arr[x][y] = '-';
		
		if(y == c-1) {
			return true;
		}
		
		if(x > 0 && arr[x-1][y+1] == '.') {
			if(DFS(x-1,y+1)) {
				return true;
			}
		}
		if(arr[x][y+1] == '.') {
			if(DFS(x,y+1)) {
				return true;
			}
		}
		if(x+1 < r && arr[x+1][y+1] == '.') {
			if(DFS(x+1,y+1)) {
				return true;
			}
		}
		return false;
	}
}
