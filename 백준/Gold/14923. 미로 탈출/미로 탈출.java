import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int x;
        int y;
        int count;
        boolean check;
        public Node(int x,int y,int count,boolean check){
            this.x = x;
            this.y = y;
            this.count = count;
            this.check = check;
        }
    }
    private static int n,m,sx,sy,ex,ey,result = -1;
    private static int[][] arr;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(result);
    }//main end

    private static void bfs(){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(sx,sy,0,false));
        boolean[][][] visited = new boolean[2][n+1][m+1];
        visited[0][sx][sy] = true;

        while(!que.isEmpty()){
            Node now = que.poll();


            if(now.x == ex && now.y == ey){
                result = now.count;
                return;
            }

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];


                if(!check(nx,ny))continue;
                if(!now.check){
                    if(arr[nx][ny]==1){
                        if(!visited[1][nx][ny]){
                            visited[1][nx][ny] = true;
                            que.offer(new Node(nx,ny,now.count+1,true));
                        }
                    }else if(arr[nx][ny] == 0){
                        if(!visited[0][nx][ny]){
                            visited[0][nx][ny] = true;
                            que.offer(new Node(nx,ny,now.count+1,false));
                        }
                    }
                }else{
                    if(!visited[1][nx][ny] && arr[nx][ny] == 0){
                        visited[1][nx][ny] = true;
                        que.offer(new Node(nx,ny,now.count+1,true));
                    }
                }
            }
        }
    }//bfs end

    private static boolean check(int x,int y){
        return x >= 1 && y >=1 && x <= n && y <= m;
    }//check end
}//class end
