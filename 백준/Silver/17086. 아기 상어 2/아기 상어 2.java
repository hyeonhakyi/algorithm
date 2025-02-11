import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Shark{
        int x;
        int y;
        int length;
        public Shark(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
    static int n,m;
    static int[][] arr;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int distinct = bfs(i,j,0);
                max = Math.max(max,distinct);
            }
        }
        System.out.println(max);
    }//main end

    static int bfs(int x, int y, int depth) {
        Queue<Shark> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;
        q.add(new Shark(x, y, depth));

        while(!q.isEmpty()) {
            Shark shark = q.poll();

            int nowX = shark.x;
            int nowY = shark.y;

            if(arr[nowX][nowY] == 1) {
                return shark.length;
            }

            for(int i = 0; i < 8; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(check(nextX,nextY)) continue;
                if(visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                q.add(new Shark(nextX, nextY, shark.length+1));
            }
        }
        return 0;
    }//bfs end

    static boolean check(int x,int y){
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}//class end
