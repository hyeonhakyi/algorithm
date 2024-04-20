import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int dir;
        int cnt;
        public Node(int x,int y,int dir,int cnt){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt,o.cnt);
        }
    }
    private static int n,answer;
    private static char[][] arr;
    private static int[][] visited;
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static Node start;
    private static PriorityQueue<Node> que = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i],-1);
        }

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == '#'){
                   start = new Node(i,j,0,0);
                }
            }
        }

        arr[start.x][start.y] = '*';

        for(int d = 0; d < 4; d++){
            int nx = start.x + dx[d];
            int ny = start.y + dy[d];

            if(!check(nx,ny))continue;
            if(arr[nx][ny] == '*')continue;
            que.offer(new Node(nx,ny,d,0));
        }

        bfs();
        System.out.println(answer);
    }//main end

    private static void bfs(){
        while(!que.isEmpty()){
            Node now = que.poll();

            if(arr[now.x][now.y] == '#'){
                answer += now.cnt;
                return;
            }

            int nx = now.x + dx[now.dir];
            int ny = now.y + dy[now.dir];

            if(!check(nx,ny))continue;
            if(arr[nx][ny] == '*')continue;
            if(visited[nx][ny] >= now.cnt)continue;

            visited[nx][ny] = now.cnt;

            if(arr[nx][ny] == '!'){
                que.offer(new Node(nx,ny,(now.dir+1)%4,now.cnt+1));
                que.offer(new Node(nx,ny,(now.dir+3)%4,now.cnt+1));
            }
            que.offer(new Node(nx,ny,now.dir,now.cnt));
        }
    }//bfs end

    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}//class end
