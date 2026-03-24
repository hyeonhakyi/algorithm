import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] degree;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        degree = new int[n + 1];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
            degree[s]++;
            degree[e]++;
        }

        boolean[] isCycle = findCycle();
        int[] dist = bfsCycle(isCycle);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb);
    }//main end

    private static boolean[] findCycle(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] remove = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            if(degree[i] == 1){
                remove[i] = true;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : list[now]){
                if(remove[next]) continue;

                degree[next]--;
                if(degree[next] == 1){
                    remove[next] = true;
                    q.offer(next);
                }
            }
        }

        boolean[] isCycle = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            if(!remove[i]){
                isCycle[i] = true;
            }
        }
        return isCycle;
    }//findCycle end

    private static int[] bfsCycle(boolean[] isCycle){
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist,-1);
        for(int i = 1; i <= n; i++){
            if(isCycle[i]){
                q.offer(i);
                dist[i] = 0;
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : list[now]){
                if(dist[next] != -1) continue;

                dist[next] = dist[now] + 1;
                q.offer(next);
            }
        }

        return dist;
    }//bfsCycle end
}//class end
