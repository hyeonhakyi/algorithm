import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k){
            System.out.println(0);
            System.out.println(n);
            return;
        }

        bfs();
    }//main end

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];
        int[] prev = new int[100001];
        Arrays.fill(prev,-1);
        dist[n] = 0;
        visited[n] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] dx = {now + 1, now - 1,now * 2};

            for(int d : dx){
                if(d < 0 || d > 100000) continue;
                if(visited[d]) continue;
                visited[d] = true;
                dist[d] = dist[now] + 1;
                prev[d] = now;

                if(d == k){
                    printAnswer(dist[d],prev);
                    return;
                }
                q.offer(d);
            }
        }
    }//bfs end

    private static void printAnswer(int dist, int[] prev) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = k; i >= 0; i = prev[i]){
            list.add(i);
        }
        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        sb.append(dist).append("\n");
        for(int i : list){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}//class end
