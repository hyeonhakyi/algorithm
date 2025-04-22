import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x;
        int y;
        int count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m, sx,sy;
    static int[][] answer;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                answer[i][j] = Integer.parseInt(st.nextToken());

                if(answer[i][j] == 2){
                    sx = i;
                    sy = j;
                    answer[i][j] = 0;
                }
            }
        }

        cal();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && answer[i][j] == 1){
                    answer[i][j] = -1;
                }
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }//main end
    public static void cal(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy, 0));
        visited[sx][sy] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(!check(nx,ny) || visited[nx][ny] || answer[nx][ny] == 0){
                    continue;
                }

                q.add(new Node(nx, ny, cur.count+1));
                visited[nx][ny] = true;
                answer[nx][ny] = cur.count+1;
            }
        }
    }//cal end

    public static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}//class end
