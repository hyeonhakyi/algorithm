import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int x;
        int y;
        int count;
        int breakWall;
        public Node(int x,int y,int count,int breakWall){
            this.x = x;
            this.y = y;
            this.count = count;
            this.breakWall = breakWall;
        }
    }
    private static int n,m,k,result = -1;
    private static int[][] arr;
    private static boolean[][][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m][k+1];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m ; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();

        System.out.println(result);
    }//main end

    private static void bfs(){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0,0,1,0));
        visited[0][0][0] = true;

        while (!que.isEmpty()){
            Node now = que.poll();

            if(now.x == n-1 && now.y == m-1){
                result = now.count;
                return;
            }

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(check(nx,ny)){
                    if(arr[nx][ny] == 0 && !visited[nx][ny][now.breakWall]){
                        que.offer(new Node(nx,ny,now.count+1, now.breakWall));
                        visited[nx][ny][now.breakWall] = true;
                    }else if(arr[nx][ny] == 1 && now.breakWall < k && !visited[nx][ny][now.breakWall+1]){
                        que.offer(new Node(nx,ny,now.count+1, now.breakWall+1));
                        visited[nx][ny][now.breakWall+1] = true;
                    }
                }
            }
        }
    }//bfs end

    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}//class end
