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
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] arr;
    static int[][] target;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        target = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                target[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean done = false;
        for(int i = 0; i < n && !done; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != target[i][j]){
                    dfs(i,j,arr[i][j],target[i][j]);
                    done = true;
                    break;
                }
            }
        }

        if(!isSame()){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }//main end

    private static void dfs(int x,int y,int original,int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;
        arr[x][y] = target;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == original){
                    arr[nx][ny] = target;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }//dfs end

    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end

    private static boolean isSame(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }//isSame end;
}//class end
