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

        int[] indegree = new int[n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            list[fir].add(sec);
            indegree[sec]++;
        }


        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");

            for(int next : list[now]){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        System.out.println(sb.toString());
    }//main end
}//class end
