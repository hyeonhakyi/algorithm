import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n,m,result;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    result = 0;
                    dfs(i,j);
                    max = Math.max(result,max);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }//main end

    private static void dfs(int x,int y){
        result++;

        for(int d= 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            visited[x][y] = true;

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    dfs(nx,ny);
                }
            }
        }
    }//dfs end
}//class end
