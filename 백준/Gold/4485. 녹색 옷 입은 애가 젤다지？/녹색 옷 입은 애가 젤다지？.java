import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int value;
        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        while(true){
            idx++;
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            arr = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = bfs();

            System.out.println("Problem" + " " + idx + ": " + answer);
        }
    }//main end

    static int bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0, 0, arr[0][0]));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowValue = now.value;

            if(nowX == n-1 && nowY == n-1){
                return nowValue;
            }

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx,ny,nowValue + arr[nx][ny]));
            }
        }
        return -1;
    }//bfs end

    static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }//check end
}//class end
