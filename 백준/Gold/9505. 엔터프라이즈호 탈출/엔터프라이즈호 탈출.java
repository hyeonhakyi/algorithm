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
        Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
    static int w,h,ex,ey;
    static int[] cost;
    static char[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            cost = new int[256];

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                char s = st.nextToken().charAt(0);
                int v =  Integer.parseInt(st.nextToken());
                cost[s] = v;
            }

            arr = new char[h][w];
            for(int i = 0; i < h; i++){
                String str = br.readLine();
                for(int j = 0; j < w; j++){
                    if(str.charAt(j) == 'E'){
                        ex = i;
                        ey = j;
                    }
                    arr[i][j] = str.charAt(j);
                }
            }

            int answer = bfs();
            System.out.println(answer);
        }//test end
    }//main end

    private static int bfs(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(ex,ey,0));
        int[][] dist = new int[h][w];
        for(int i = 0; i < h; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[ex][ey] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int nowX =  cur.x;
            int nowY = cur.y;
            int nowValue = cur.value;

            if (nowValue > dist[cur.x][cur.y]) continue;

            if(isBoundary(nowX,nowY)){
                return nowValue;
            }

            for(int d = 0; d < 4; d++){
                int nextX = nowX + dx[d];
                int nextY = nowY + dy[d];

                if(!check(nextX, nextY)) continue;
                int nextValue = nowValue + cost[arr[nextX][nextY]];

                if(dist[nextX][nextY] > nextValue){
                    dist[nextX][nextY] = nextValue;
                    q.offer(new Node(nextX,nextY,nextValue));
                }
            }
        }

        return -1;
    }//bfs end

    private static boolean check(int x,int y){
        return x >= 0 && x < h && y >= 0 && y < w;
    }//check end

    private static boolean isBoundary(int x, int y) {
        return x == 0 || x == h - 1 || y == 0 || y == w - 1; // 수정: 모서리 포함
    }//isBoundary end
}//class end
