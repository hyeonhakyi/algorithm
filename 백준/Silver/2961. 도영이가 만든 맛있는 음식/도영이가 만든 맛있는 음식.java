import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] s;
	static int[] b;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n];
		b = new int[n]; 
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,1,0,0);
		System.out.println(result);
		
	}
	
	public static void dfs(int l , int sin, int bin, int count) {
		if(l == n) {
			if(count != 0 && result > Math.abs(sin - bin)) 
				result = Math.abs(sin - bin);
				return;
		}
		dfs(l+1,sin*s[l],bin+b[l],count+1);
		dfs(l+1,sin,bin,count);	
		
	}	
}
