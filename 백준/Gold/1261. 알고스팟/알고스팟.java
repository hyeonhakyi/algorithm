import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
    private static int n,m,result=Integer.MAX_VALUE;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+1][n+1];
        visited = new boolean[m+1][n+1];

        for(int i = 1; i < m+1; i++){
            String s = br.readLine();
            for(int j = 1; j < n+1; j++){
                arr[i][j] = s.charAt(j-1) - '0';
            }
        }
        bfs();
        System.out.println(result);
    }//main end

    private static void bfs(){
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(1,1,0));
        visited[1][1] = true;

        while (!que.isEmpty()){
            Node now = que.poll();
            int nowX = now.x;
            int nowY = now.y;
            int count = now.count;

            if(nowX == m && nowY == n){
                result = count;
                return;
            }

            for(int d = 0; d < 4; d++){
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];

                if(nx >= 1 && ny >= 1 && nx <= m && ny <= n){
                    if(!visited[nx][ny]){
                        if(arr[nx][ny] == 1){
                            visited[nx][ny] = true;
                            que.offer(new Node(nx,ny,count+1));
                        }else {
                            visited[nx][ny] = true;
                            que.offer(new Node(nx,ny,count));
                        }
                    }
                }
            }





        }
    }//bfs end
}//class end

