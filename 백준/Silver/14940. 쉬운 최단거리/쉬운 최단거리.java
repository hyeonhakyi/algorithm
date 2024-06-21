import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int x;
        int y;
        int count;
        public Node(int x, int y,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    private static int[][] map;
    private static int n,m,sx,sy;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2){
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        bfs();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    map[i][j] = -1;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }//main end

    private static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy,0));
        visited[sx][sy] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx,ny))continue;
                if(visited[nx][ny])continue;
                if(map[nx][ny] == 0)continue;

                q.offer(new Node(nx, ny, now.count+1));
                visited[nx][ny] = true;
                map[nx][ny] = now.count+1;
            }
        }
    }//bfs end

    private static boolean check(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}//class end
