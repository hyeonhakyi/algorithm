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

        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new LinkedList<>();
        }

        int[] indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            for(int j = 1; j < a; j++){
                int cur = Integer.parseInt(st.nextToken());
                list[prev].add(cur);
                indegree[cur]++;
                prev = cur;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append("\n");
            count++;

            for(int next : list[cur]){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        if(count != n){
            System.out.println(0);
        }else{
            System.out.println(sb);
        }
    }//main end
}//class end
