import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,min = Integer.MAX_VALUE;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        visited = new boolean[2][n+1][m+1];

        for(int i = 1; i <= n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j+1] = s.charAt(j) - '0';
            }
        }

        bfs(1,1);
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min);
        }
    }

    static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {x,y,0,1});
        visited[0][x][y] = true;

        while(!que.isEmpty()){
            int now[] = que.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowZ = now[2];
            int Count = now[3];
            if(nowX == n && nowY == m){
                if(min > Count){
                    min = Count;
                }
            }

            for(int d = 0; d < 4; d++){
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                if(nx >= 1 && ny >= 1 && nx <= n && ny <= m){
                    if(visited[nowZ][nx][ny]) continue;
                    if(arr[nx][ny] == 1){
                        if(nowZ == 1)continue;
                        visited[nowZ][nx][ny] = true;
                        que.offer(new int[] {nx,ny, 1,Count+1});
                    }
                    else{
                        visited[nowZ][nx][ny] = true;
                        que.offer(new int[] {nx,ny,nowZ,Count+1});
                    }
                }
            }
        }
    }
}
