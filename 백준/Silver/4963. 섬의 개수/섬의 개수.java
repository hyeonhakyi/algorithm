
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,count;
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,-1,1};
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            visited = new boolean[m][n];
            count = 0;
            
            if(n == 0 && m == 0){
                break;
            }
            
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == 1 && !visited[i][j]){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    private static void dfs(int x, int y){
        visited[x][y] =true;

        for(int d = 0; d < 8; d++){
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n)continue;
            if(arr[nextX][nextY] == 1 && !visited[nextX][nextY]){
                dfs(nextX,nextY);
            }
        }
    }
}
