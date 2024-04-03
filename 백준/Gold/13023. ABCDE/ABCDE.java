import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,m,answer;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		list = new ArrayList[n];
		
		
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		
		for(int i = 0; i < n; i++) {
			if(answer == 0) {
				dfs(1,i);
			}
		}
		
		
		System.out.println(answer);
	}
	
	
	private static void dfs(int count,int start) {
		if(count == 5) {
			answer = 1;
			return;
		}
		
		visited[start] = true;
		for(int i : list[start]) {
			int next = i;
			if(!visited[next]) {
				dfs(count+1,next);
			}
		}
		visited[start] = false;
	}
}
