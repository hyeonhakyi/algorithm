import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L,C;
	static char[] arr;
	static boolean[] visited;
	static char[] copy;
	static String str;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		str = "aeiou";
		arr = new char[C];
		visited = new boolean[C];
		copy = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		dfs(0,0);
		
	}
	
	private static void dfs(int count, int start) {
		if(count == L) {
			int acount = 0;
			int jcount = 0;
			for(int i = 0; i < copy.length; i++) {
				if(str.contains(String.valueOf(copy[i]))) {
					acount++;
				}else {
					jcount++;
				}
			}
			if(acount >= 1 && jcount >=2) {
				for(char i : copy) {
					System.out.print(i);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			if(!visited[i]) {
				visited[start] = true;
				copy[count] = arr[i];
				dfs(count+1,i+1);
				visited[start] = false;
			}
		}
	}
}
