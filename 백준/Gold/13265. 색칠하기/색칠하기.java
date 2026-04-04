import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int[] color;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list = new List[n + 1];
            color = new int[n + 1];

            for(int i = 1; i <= n; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                list[s].add(e);
                list[e].add(s);
            }

            boolean possible = true;
            for(int i = 1; i <= n; i++){
                if(color[i] == 0){
                    if(!bfs(i)){
                        possible = false;
                        break;
                    }
                }
            }

            if(!possible){
                sb.append("impossible").append("\n");
            }else{
                sb.append("possible").append("\n");
            }
        }//testCase end

        System.out.println(sb.toString());
    }//main end

    private static boolean bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        color[idx] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : list[now]){
                if(color[next] == 0){
                    color[next] = -color[now];
                    q.offer(next);
                }else{
                    if(color[next] == color[now]){
                        return false;
                    }
                }
            }
        }
        return true;
    }//bfs end
}//class end
