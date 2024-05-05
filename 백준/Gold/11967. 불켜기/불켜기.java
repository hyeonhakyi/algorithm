
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int n,m,result = 1;
    private static boolean[][] light;
    private static boolean[][] visited;
    private static ArrayList<Node>[][] list;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1][n+1];
        visited = new boolean[n+1][n+1];
        light = new boolean[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j= 1; j <= n; j++){
                list[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            list[x][y].add(new Node(nx, ny));
        }
        bfs();

        System.out.println(result);
    }//main end

    private static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 1));
        visited[1][1] = true;
        light[1][1] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            while(!list[now.x][now.y].isEmpty()){
                visited = new boolean[n+1][n+1];
                visited[now.x][now.y] = true;
                for(Node next : list[now.x][now.y]){
                    if(!light[next.x][next.y]){
                        light[next.x][next.y] = true;
                        result++;
                    }
                }
                list[now.x][now.y].clear();
            }

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx, ny))continue;
                if(light[nx][ny] && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }//bfs end

    private static boolean check(int x, int y){
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }//check end
}//class end
