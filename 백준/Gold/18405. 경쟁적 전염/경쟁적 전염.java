import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int value;
        public Node(int x,int y,int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value,o.value);
        }
    }
    private static int n,k;
    private static int[][] arr;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static PriorityQueue<Node> que = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        for(int i = 0; i < s; i++){
            if(arr[endX][endY] != 0){
                break;
            }
            reset();
            bfs();
        }

        if(arr[endX][endY] == 0 || arr[endX][endY] > k){
            System.out.println(0);
        }else{
            System.out.println(arr[endX][endY]);
        }
    }//main end

    private static void bfs(){
        while (!que.isEmpty()){
            Node now = que.poll();

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(check(nx,ny) && arr[nx][ny] == 0){
                    arr[nx][ny] = now.value;
                }
            }
        }
    }//bfs end

    private static void reset(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(arr[i][j] != 0){
                    que.offer(new Node(i,j,arr[i][j]));
                }
            }
        }
    }//reset end


    private static boolean check(int x,int y){
        return x >= 1 && y >= 1 && x < n+1 && y < n+1;
    }
}//class end
