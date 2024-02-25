import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m,n,k,count;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];

        for(int d = 0; d < k; d++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = y1; i < y2; i++){
                for(int j = x1; j < x2; j++){
                    arr[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] &&arr[i][j] == 0){
                    count = 1;
                    dfs(i,j);
                    cnt++;
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(cnt);
        for(int i : list){
            System.out.print(i + " ");
        }
    }

    static void dfs(int x,int y){
        visited[x][y] = true;

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                if(!visited[nx][ny] && arr[nx][ny] == 0){
                    count++;
                    dfs(nx,ny);
                }
            }
        }
    }
}
