import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] wave = new long[101];
		wave[1] = 1;
		wave[2] = 1;
		wave[3] = 1;
		wave[4] = 2;
		wave[5] = 2;

		for (int i = 6; i < 101; i++) {
			wave[i] = wave[i - 3] + wave[i - 2];
		}

		for (int i = 0; i < n; i++) {
			System.out.println(wave[Integer.parseInt(br.readLine())]);
		}

	}// main end
}// class end
