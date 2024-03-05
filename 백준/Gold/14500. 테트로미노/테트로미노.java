import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n,m,max;
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
        max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    dfs(i,j,arr[i][j],1);
                    visited[i][j] = false;
                }
            }
        }
        System.out.println(max);
    }//main end

    private static void dfs(int x,int y,int sum,int count){
        if(count == 4){
            max = Math.max(max,sum);
            return;
        }
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(!visited[nx][ny]){
                    if(count == 2){
                        visited[nx][ny] = true;
                        dfs(x,y,sum + arr[nx][ny],count+1);
                        visited[nx][ny] = false;
                    }
                    visited[nx][ny] = true;
                    dfs(nx,ny,sum + arr[nx][ny],count+1);
                    visited[nx][ny] = false;
                }
            }
        }
    }//dfs end
}//class end
