import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[101];

        for(int i = 0; i < 101; i++){
            arr[i] = i;
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x] = y;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x] = y;
        }

        bfs();
        System.out.println(answer);
    }//main end

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] check = new int[101];
        check[1] = 0;

        while(true){
            int now = q.poll();

            for(int i = 1; i < 7; i++){
                int next = now + i;

                if(next > 100){
                    continue;
                }

                if(check[arr[next]] == 0){
                    q.offer(arr[next]);
                    check[arr[next]] = check[arr[now]] + 1;
                }

                if(arr[next] == 100){
                    answer = check[next];
                    return;
                }
            }
        }
    }//bfs end
}//class end
