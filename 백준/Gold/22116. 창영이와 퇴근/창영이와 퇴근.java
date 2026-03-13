import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int value;
        public Node(int x,int y,int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.value, o.value);
        }
    }
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dist;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dijkstr();

        System.out.println(dist[n-1][n-1]);
    }//main end

    private static void dijkstr(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.value > dist[now.x][now.y]) continue;

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx,ny)) continue;

                int slope = Math.abs(arr[nx][ny] - arr[now.x][now.y]);
                int nextValue = Math.max(slope,dist[now.x][now.y]);

                if(nextValue < dist[nx][ny]){
                    dist[nx][ny] = nextValue;
                    q.offer(new Node(nx, ny, nextValue));
                }
            }
        }
    }//dijkstra end

    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }//check end
}//class end
