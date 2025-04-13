import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	private static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		//입력받은 수만큼 카드 채우기
		for(int i = 1; i<= n; i++) {
			q.offer(i);
		}
		//q의 사이즈가 1이 될때까지 첫장을 버리고 다음장을 맨뒤에 추가
		while(q.size()>1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.poll());
	}
}
