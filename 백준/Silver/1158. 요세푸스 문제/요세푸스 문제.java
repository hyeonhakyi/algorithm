import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		int idx = 0;
		
		while(q.size() > 1) {
			idx = (idx + (k-1)) % q.size();
			sb.append(q.remove(idx)).append(", ");
			
			
		}
		sb.append(q.remove()).append(">");
		System.out.println(sb);
	}
}
