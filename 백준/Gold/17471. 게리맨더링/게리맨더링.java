import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n,result = Integer.MAX_VALUE;
	private static int[] arr;
	private static boolean[] visited;
	private static boolean[] check;
	private static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		visited = new boolean[n+1];
		list = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		dfs(0);
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}//main end
	
	private static void dfs(int count) {
		if(count == n) {
			ArrayList<Integer> truelist = new ArrayList<>();
			ArrayList<Integer> falseList = new ArrayList<>();
			
			for(int i = 1; i <= n; i++) {
				if(visited[i]) {
					truelist.add(i);
				}else {
					falseList.add(i);
				}
			}
			if(truelist.isEmpty() || falseList.isEmpty()) {
				return;
			}
			
			if(bfs(truelist) && bfs(falseList)) {
				diff();
			}
			return;
		}
		
		visited[count] = true;
		dfs(count + 1);
		visited[count] = false; 
		dfs(count + 1);
	}//dfs end
	
	private static boolean bfs(ArrayList<Integer> arr) {
		Queue<Integer> que = new LinkedList<>();
		check = new boolean[n+1];
		que.offer(arr.get(0));
		check[arr.get(0)] = true;
		
		int cnt = 1;
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				if(arr.contains(next) && !check[next]) {
					que.offer(next);
					check[next] = true;
					cnt++;
				}
			}
		}
		if(cnt == arr.size()) {
			return true;
		}else {
			return false;
		}
	}//bfs end
	
	private static void diff() {
		int trueSum = 0;
		int falseSum = 0;
		
		for(int i = 1; i <= n; i++) {
			if(check[i]) {
				trueSum += arr[i];
			}else{
				falseSum += arr[i];
			}
		}
		result = Math.min(result,Math.abs(falseSum - trueSum));
	}//diff end
}//class end
