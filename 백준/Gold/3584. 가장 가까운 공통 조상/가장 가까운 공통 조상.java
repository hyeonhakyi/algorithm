import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] parent = new int[n + 1];
            StringTokenizer st;
            for(int i = 0; i < n - 1; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            boolean[] visited = new boolean[n + 1];
            int x = a;
            while(x != 0){
                visited[x] = true;
                x = parent[x];
            }

            int y = b;
            while(!visited[y]){
                y = parent[y];
            }

            sb.append(y).append("\n");
        }//testCase end
        System.out.println(sb.toString());
    }//main end
}//class end
