
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r,c,max;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static boolean[] visited = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                arr[i][j] = s.charAt(j) - 'A';
            }
        }
        dfs(0,0,1);
        System.out.println(max);
    }
    public static void dfs(int x, int y, int count){
        visited[arr[x][y]] = true;
        max = Math.max(max,count);

        for(int d = 0; d < 4; d++){
            int moveX = x + dx[d];
            int moveY = y + dy[d];

            if(moveX >= 0 && moveY >= 0 && moveX < r && moveY < c){
                if(visited[arr[moveX][moveY]] == false){
                    dfs(moveX,moveY,count+1);
                    visited[arr[moveX][moveY]] = false;
                }
            }
        }
    }
}
