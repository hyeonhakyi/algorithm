import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int count;
        int dir;
        public Node(int x, int y, int count, int dir) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.count, o.count);
        }
    }
    private static int[][] arr;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1,};
    private static int[][] visited;
    private static int n,m;
    private static boolean[][][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new int[n][m];
        isVisited = new boolean[n][m][n*m];
        Node start = null;
        for(int[] arr : visited){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        boolean isCheck = false;
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                if(s.charAt(j) == 'C' && !isCheck){
                    isCheck = true;
                    start = new Node(i,j,0,-1);
                    arr[i][j] = 0;
                }else if(s.charAt(j) == 'C' && isCheck){
                    arr[i][j] = 2;
                }else if(s.charAt(j) == '*'){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 0;
                }
            }
        }
        bfs(start);
    }//main end

    private static void bfs(Node start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(start);
        visited[start.x][start.y] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(arr[now.x][now.y] == 2){
                System.out.println(now.count);
                break;
            }

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx,ny))continue;
                if(arr[nx][ny] == 1)continue;

                if(now.dir != -1 && now.dir != d){
                    if(visited[nx][ny] >= now.count +1){
                        visited[nx][ny] = now.count + 1;
                        pq.offer(new Node(nx,ny, now.count+1, d));
                    }
                }else{
                    if(visited[nx][ny] >= now.count && (now.dir == -1 || !isVisited[nx][ny][now.count+d])){
                        visited[nx][ny] = now.count;
                        isVisited[nx][ny][now.count+d] = true;
                        pq.offer(new Node(nx,ny, now.count, d));
                    }
                }
            }
        }
    }//bfs end

    private static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }//check end
}//class end
