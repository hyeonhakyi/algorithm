import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int h,w;
    private static int[][] arr;
    private static Queue<Node> q = new LinkedList<>();
    private static int[] dx = {-1,-1,-1,0,1,1,1,0};
    private static int[] dy = {-1,0,1,1,1,0,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[h][w];

        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                if(s.charAt(j) == '.'){
                    arr[i][j] = 0;
                    q.offer(new Node(i, j));
                }else{
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
        }
        bfs();
    }//main end

    private static void bfs(){
        int time = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            time++;

            for(int i = 0; i < size; i++) {
                Node now = q.poll();

                for (int d = 0; d < 8; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(!check(nx, ny))continue;
                    if(1 <= arr[nx][ny] && arr[nx][ny] <= 8){
                        arr[nx][ny]--;
                        if(arr[nx][ny] == 0){
                            q.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }
        System.out.println(time);
    }//bfs end

    private static boolean check(int x,int y){
        return x >= 0 && x < h && y >= 0 && y < w;
    }//check end
}//class end
