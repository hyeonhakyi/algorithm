import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static class Node implements Comparable<Node>{
		int idx;
		int weight;
		public Node(int idx,int weight) {
			this.idx = idx;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	private static int v,e,p;
	private static ArrayList<Node>[] list;
	private static int[] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[v+1];
		
		for(int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, value));
			list[to].add(new Node(from, value));
		}
		dijkstra(1);
		int tempD = dist[v];
		int temp = dist[p];
		dijkstra(p);
		int temp2 = dist[v];
		
		if(tempD == (temp + temp2)) {
			System.out.println("SAVE HIM");
		}else {
			System.out.println("GOOD BYE");
		}
	}//main end
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		boolean[] visited = new boolean[v+1];
		que.offer(new Node(start, 0));
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			if(visited[now.idx])continue;
			visited[now.idx] = true;
			
			for(Node next : list[now.idx]) {
				if(dist[next.idx] > dist[now.idx] + next.weight) {
					dist[next.idx] = dist[now.idx] + next.weight;
					que.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
	}//dijkstra end
}//class end
