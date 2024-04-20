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
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int n,m;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0,-1,-1,1,1};
    private static int[] dy = {0,0,-1,1,-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j])continue;
                if(bfs(i,j)){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }//main end

    private static boolean bfs(int x,int y){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x,y));
        int height = arr[x][y];
        visited[x][y] = true;
        boolean IsCheck = true;


        while (!que.isEmpty()){
            Node now = que.poll();

            for(int d = 0; d < 8; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx,ny))continue;
                if(arr[nx][ny] > height){
                    IsCheck = false;
                }else{
                    if(!visited[nx][ny] && arr[nx][ny] == height){
                        visited[nx][ny] = true;
                        que.offer(new Node(nx,ny));
                    }
                }
            }
        }
        return IsCheck;
    }//bfs end


    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}//class end
