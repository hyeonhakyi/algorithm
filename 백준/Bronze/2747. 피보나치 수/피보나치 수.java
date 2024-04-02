import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] fibonaci = new int[46];
		
		fibonaci[0] = 0;
		fibonaci[1] = 1;
		fibonaci[2] = 1;
		
		
		for(int i = 3; i < n+1; i++) {
			fibonaci[i] = fibonaci[i-1] + fibonaci[i-2];
		}
		
		System.out.println(fibonaci[n]);
	}//main end
}//class end
