import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        int[] outDeg = new int[n + 1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            outDeg[u]++;
        }

        int s = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < s; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[num] = true;
        }

        if(arr[1]){
            System.out.println("Yes");
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            if(outDeg[now] == 0){
                System.out.println("yes");
                return;
            }

            for(int next : list[now]){
                if(arr[next]) continue;
                if(visited[next]) continue;
                visited[next] = true;
                q.offer(next);
            }
        }

        System.out.println("Yes");
    }//main end
}//class end
