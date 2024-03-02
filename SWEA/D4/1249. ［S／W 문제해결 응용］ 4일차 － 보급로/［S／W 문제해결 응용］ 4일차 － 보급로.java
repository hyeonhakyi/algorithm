import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int time;
        public Node(int x,int y,int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if(this.time > o.time){
                return 1;
            }else if(this.time < o.time){
                return -1;
            }
            return 0;
        }
    }
    private static int n,min;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0}; //상 하 좌 우
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visited = new boolean[n][n];
            min = Integer.MAX_VALUE;

            for(int i = 0; i < n ; i++){
                String s = br.readLine();
                for(int j = 0; j < n; j++){
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
            bfs(0,0);
            System.out.println("#" + tc + " " + min);
        }//test_case end
    }//main end

    private static void bfs(int x,int y){
        PriorityQueue<Node> node = new PriorityQueue<>();
        node.offer(new Node(x,y,0));
        visited[x][y] = true;

        while (!node.isEmpty()){
            Node now = node.poll();

            int nowX = now.x;
            int nowY = now.y;
            int time = now.time;

            if(nowX == n-1 && nowY == n-1){
                min = Math.min(time,min);
            }

            for(int d = 0; d < 4; d++){
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(!visited[nx][ny]){
                        int nTime = time + arr[nx][ny];
                        visited[nx][ny] = true;
                        node.offer(new Node(nx,ny,nTime));
                    }
                }
            }
        }
    }//dfs end
}//class end
