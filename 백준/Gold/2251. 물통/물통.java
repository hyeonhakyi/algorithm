import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static class Water{
		int a;
		int b;
		int c;
		public Water(int a,int b,int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	private static int maxA,maxB,maxC;
	private static ArrayList<Integer> arr = new ArrayList<>();
	private static boolean[][][] visited = new boolean[201][201][201];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		maxA = Integer.parseInt(st.nextToken());
		maxB = Integer.parseInt(st.nextToken());
		maxC = Integer.parseInt(st.nextToken());
		
		
		dfs();
		Collections.sort(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}//main end
	
	
	private static void dfs() {
		Queue<Water> que = new LinkedList<>();
		que.offer(new Water(0, 0, maxC));
		
		while(!que.isEmpty()){
			Water water = que.poll();
			int a = water.a;
			int b = water.b;
			int c = water.c;
			
			if(visited[a][b][c] == true) {
				continue;
			}
			
			visited[a][b][c] = true;
			
			if(a==0) arr.add(c);
			
			//A -> B
			if(a + b >= maxB) {
				que.add(new Water(a-(maxB-b),maxB,c));
			}else {
				que.add(new Water(0,a+b,c));
			}
			//A -> C
			if(a+c >= maxC) {
				que.add(new Water(a-(maxC-c), b, maxC));
			}else {
				que.add(new Water(0, b, a+c));
			}
			//B -> A
			if(b + a >= maxA) {
				que.add(new Water(maxA,b-(maxA-a), c));
			}else {
				que.add(new Water(b+a, 0, c));
			}
			//B -> C
			if(b + c >= maxC) {
				que.add(new Water(a, b-(maxC-c), maxC));
			}else {
				que.add(new Water(a, 0, c+b));
			}
			//C -> A
			if(c + a >= maxA) {
				que.add(new Water(maxA, b, c-(maxA-a)));
			}else {
				que.add(new Water(a+c, b, 0));
			}
			//C -> B
			if(c + b >= maxB) {
				que.add(new Water(a, maxB, c-(maxB-b)));
			}else {
				que.add(new Water(a, b+c, 0));
			}
		}
	}//dfs end
}//class end
