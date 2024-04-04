import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T,n;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a-1] = b;
			}
			
			int count = 1;
			int rating = arr[0];
			for(int i = 0; i < n; i++) {
				if(rating > arr[i]) {
					count++;
					rating = arr[i];
				}
			}
			System.out.println(count);
		}
	}
}
