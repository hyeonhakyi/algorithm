import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static boolean[][] enemy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        enemy = new boolean[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            parents[i] = i;
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(str.equals("F")){
                union(x, y);
            }else{
                enemy[x][y] = true;
                enemy[y][x] = true;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(enemy[i][j]){
                    for(int k = 1; k <= n; k++){
                        if(enemy[j][k]){
                            union(i, k);
                        }
                    }
                }
            }
        }

        boolean[] visited = new boolean[n + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int root = find(i);
            if(!visited[root]){
                visited[root] = true;
                answer++;
            }
        }

        System.out.println(answer);
    }//main end

    private static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }//find end

    private static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a != b) parents[b] = a;
    }//union end
}//class end
