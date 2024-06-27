import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Integer.parseInt(br.readLine());

		if (N < 0 || N > 20)
			return;

		if (N == 0) {

			System.out.println(1);

			return;

		}

		long result = N;

		for (long i = N - 1; i >= 1; i--) {

			result = result * i;

		}

		System.out.println(result);

	}
}