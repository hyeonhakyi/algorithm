import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    private static class Node{
        int x;
        int y;
        int time;
        int legend;
        public Node(int x,int y,int time,int legend){
            this.x = x;
            this.y = y;
            this.time = time;
            this.legend = legend;
        }
    }
    private static int n,m,t,result = Integer.MAX_VALUE;
    private static int[][] arr;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        if(result == Integer.MAX_VALUE){
            System.out.println("Fail");
        }else{
            System.out.println(result);
        }
    }//main end

    private static void bfs(){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0,0,0,0));

        while(!que.isEmpty()){
            Node now = que.poll();

            if(now.time > t){
                return;
            }

            if(now.x == n -1 && now.y == m - 1){
                result = now.time;
                return;
            }

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(now.legend == 0){
                    if(check(nx,ny) && !visited[nx][ny][now.legend] && arr[nx][ny] != 1){
                        if(arr[nx][ny] == 2){
                            que.offer(new Node(nx,ny,now.time+1,1));
                            visited[nx][ny][1] = true;
                        }else{
                            que.offer(new Node(nx,ny,now.time+1,0));
                            visited[nx][ny][0] = true;
                        }
                    }
                }else{
                    if(check(nx,ny) && !visited[nx][ny][now.legend]){
                        que.offer(new Node(nx,ny,now.time+1,1));
                        visited[nx][ny][now.legend] = true;
                    }
                }
            }
        }
    }//bfs end

    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}//class end
