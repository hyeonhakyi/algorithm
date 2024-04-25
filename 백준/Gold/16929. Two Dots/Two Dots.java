import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n,m,sx,sy;
    private static char[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited = new boolean[n][m];
                sx = i;
                sy = j;
                if(dfs(i,j,1)){
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("No");
    }//main end

    private static boolean dfs(int x,int y,int count){
        visited[x][y] = true;
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!check(nx,ny))continue;
            if(arr[nx][ny] == arr[x][y] && !visited[nx][ny]){
                visited[nx][ny] = true;
                if(dfs(nx,ny,count+1)){
                    return true;
                }
            }
            if(count >= 4 && sx == nx && sy == ny){
                return true;
            }
        }
        return false;
    }//dfs end

    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }//check end
}//class end
