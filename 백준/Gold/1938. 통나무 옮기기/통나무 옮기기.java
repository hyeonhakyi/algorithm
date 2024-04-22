
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    private static class Node {
        int x;
        int y;
        int dir;
        int count;

        public Node(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }

    private static int n;
    private static char[][] arr;
    private static Point[] sw,ew;
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        sw = new Point[3];
        ew = new Point[3];

        int sIdx = 0; int eIdx = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == 'B'){
                    sw[sIdx++] = new Point(i,j);
                }

                if(arr[i][j] == 'E') {
                    ew[eIdx++] = new Point(i, j);
                }
            }
        }

        int ans = bfs();
        System.out.println(ans);
    }// main end

    private static int bfs() {
        Queue<Node> que = new LinkedList<>();
        boolean[][][] visited = new boolean[2][n][n];

        int dir = 0;
        if(sw[0].y+1 == sw[1].y){
            dir = 0;
        }else{
            dir = 1;
        }

        que.offer(new Node(sw[1].x,sw[1].y,dir,0));
        visited[dir][sw[1].x][sw[1].y] = true;
        while (!que.isEmpty()) {
            Node now = que.poll();

            if (now.x == ew[1].x && now.y == ew[1].y) {
                if(now.dir == 0 && arr[now.x][now.y-1] == 'E' && arr[now.x][now.y+1] == 'E'){
                    return now.count;
                }else if(now.dir == 1 && arr[now.x-1][now.y] == 'E' && arr[now.x+1][now.y] == 'E'){
                    return now.count;
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!moveCheck(nx,ny,now.dir,d))continue;
                if(visited[now.dir][nx][ny])continue;

                visited[now.dir][nx][ny] = true;
                que.offer(new Node(nx,ny,now.dir,now.count+1));
            }

            if(turnCheck(now.x,now.y)){
                if(now.dir == 0 && !visited[1][now.x][now.y]){
                    visited[1][now.x][now.y] = true;
                    que.offer(new Node(now.x,now.y,1,now.count+1));
                }else if(now.dir == 1 && !visited[0][now.x][now.y]){
                    visited[0][now.x][now.y] = true;
                    que.offer(new Node(now.x,now.y,0,now.count+1));
                }
            }
        }
        return 0;
    }// bfs end

    private static boolean turnCheck(int x, int y) {
        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++) {
                // 범위 나간 경우
                if(!check(i,j)) {
                    return false;
                }
                // 나무 있는 경우
                if(arr[i][j] == '1') {
                    return false;
                }
            }
        }

        return true;
    }// turnCheck end

    private static boolean moveCheck(int x, int y, int dir,int t) {
        switch (dir){
            case 0:
                if(t < 2){
                    if(x < 0 || x >= n) {
                        return false;
                    }
                    if(arr[x][y] == '1' || arr[x][y-1] == '1' || arr[x][y+1] == '1'){
                        return false;
                    }
                }else{
                    if(y - 1 < 0 || y + 1 >= n){
                        return false;
                    }
                    if(arr[x][y] == '1' || arr[x][y-1] == '1' || arr[x][y+1] == '1'){
                        return false;
                    }
                }
                break;
            case 1:
                if(t < 2){
                    if(x - 1 < 0 || x + 1 >= n) {
                        return false;
                    }
                    if(arr[x][y] == '1' || arr[x-1][y] == '1' || arr[x+1][y] == '1'){
                        return false;
                    }
                }else{
                    if(y < 0 || y >= n){
                        return false;
                    }
                    if(arr[x][y] == '1' || arr[x-1][y] == '1' || arr[x+1][y] == '1'){
                        return false;
                    }
                }
                break;

            default:
                break;
        }
        return true;
    }// turnCheck end

    private static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }// check end
}// class end
