import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int v,e;
    private static ArrayList<Integer>[] arr;
    private static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for(int t = 0; t < k; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            arr = new ArrayList[v+1];
            visited = new int[v+1];

            for(int i = 1; i < v+1; i++){
                arr[i] = new ArrayList<>();
            }

            for(int i = 0; i < e; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x].add(y);
                arr[y].add(x);
            }
            bfs(1);
        }
    }//main end

    private static void bfs(int x){
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <= v; i++){
            if(visited[i] == 0){
                que.offer(i);
                visited[i] = 1;
            }

            while (!que.isEmpty()){
                int now = que.poll();

                for(int next : arr[now]){
                    if(visited[next] == visited[now]){
                        System.out.println("NO");
                        return;
                    }if(visited[next] == 0){
                        que.offer(next);
                        if(visited[now] == 1){
                            visited[next] = 2;
                        }else{
                            visited[next] = 1;
                        }
                    }
                }
            }
        }
        System.out.println("YES");
        return;
    }//bfs end
}//clas end
