import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int count;
        public Node(int x,int y,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.count,o.count);
        }
    }
    private static int[][] arr = new int[501][501];
    private static int[][] visited = new int[501][501];
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int min = Integer.MAX_VALUE;
    private static PriorityQueue<Node> que = new PriorityQueue<>();
    private static int goal = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());

            for(int j = Math.min(fx,lx); j <= Math.max(fx,lx); j++){
                for(int k = Math.min(fy,ly); k <= Math.max(fy,ly); k++){
                    arr[j][k] = 1;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());

            for(int j = Math.min(fx,lx); j <= Math.max(fx,lx); j++){
                for(int k = Math.min(fy,ly); k <= Math.max(fy,ly); k++){
                    arr[j][k] = 2;
                }
            }
        }

        que.offer(new Node(0,0,1));
        while (!que.isEmpty()){
            int k = que.size();
            for(int i = 0; i < k; i++) {
                Node p = que.poll();
                if (visited[p.x][p.y] == 0) {
                    visited[p.x][p.y] = 1;
                }
                bfs(p);
            }
        }
        if(goal == 1){
            System.out.println(min-1);
        }else{
            System.out.println(-1);
        }
    }//main end

    private static void bfs(Node p){
        for(int d = 0; d < 4; d++){
            int nx = p.x + dx[d];
            int ny = p.y + dy[d];
            int nc = p.count;

            if(check(nx,ny) && arr[nx][ny] != 2){
                if(visited[nx][ny] != 0 && visited[nx][ny] <= p.count){
                    continue;
                }

                if(arr[nx][ny] == 1){
                    nc++;
                }

                if(nx == 500 && ny == 500){
                    min = Math.min(min,nc);
                    goal = 1;
                }
                visited[nx][ny] = p.count;
                que.offer(new Node(nx,ny,nc));
            }
        }
    }

    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < 501 && y < 501;
    }
}//class end
