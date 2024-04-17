import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n,m,result;
    private static char[][] arr;
    private static boolean[][] visited;
    private static boolean[][] finish;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];
        finish = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    dfs(arr[i][j],i,j);
                }
            }
        }
        System.out.println(result);
    }//main end

    private static void dfs(char dir,int x,int y){
        if(!check(x,y))return;
        visited[x][y] = true;

        int nx = x + dx[dirChange(dir)];
        int ny = y + dy[dirChange(dir)];

        if(!visited[nx][ny]){
            dfs(arr[nx][ny],nx,ny);
        }else{
            if(!finish[nx][ny]){
                result++;
            }
        }
        finish[x][y] = true;
    }//dfs end

    private static int dirChange(char dir){
        switch (dir){
            case 'U' : return 0;
            case 'D' : return 1;
            case 'L' : return 2;
            case 'R' : return 3;
            default: return -1;
        }
    }

    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}//class end
