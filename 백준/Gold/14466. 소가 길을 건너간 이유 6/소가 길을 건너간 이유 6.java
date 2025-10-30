import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][][] visited;
    static int[][] arr;
    static int n,k,r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1 ][n + 1][4];

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());

            int d = dir(r,c,r1,c1);
            int od = op(d);

            visited[r][c][d] = true;
            visited[r1][c1][od] = true;
        }

        Node[] cows = new Node[k];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cows[i] = new Node(r, c);
        }

        arr = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(arr[i],-1);
        }

        int compId = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(arr[i][j] == -1){
                    bfs(i,j,compId);
                    compId++;
                }
            }
        }

        int[] cnt = new int[compId];
        for(Node cow : cows){
            cnt[arr[cow.x][cow.y]]++;
        }

        long answer = 0;
        long pref = 0;
        for(int i = 0; i < compId; i++){
            answer += (long) cnt[i] * pref;
            pref += cnt[i];
        }

        System.out.println(answer);
    }//main end

    private static int dir(int r, int c, int r1, int c1){
        if(r1 == r - 1 && c1 == c) return 0;
        if(r1 == r + 1 && c1 == c) return 1;
        if(r1 == r && c1 == c - 1) return 2;
        if(r1 == r && c1 == c + 1) return 3;
        return -1;
    }//dir end

    private static int op(int d){
        if(d == 0) return 1;
        if(d == 1) return 0;
        if(d == 2) return 3;
        return 2;
    }//op end

    private static void bfs(int x,int y,int id){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        arr[x][y] = id;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx,ny)) continue;
                if(visited[now.x][now.y][d]) continue;
                if(arr[nx][ny] != -1) continue;
                arr[nx][ny] = id;
                q.offer(new Node(nx,ny));
            }
        }

    }

    private static boolean check(int x,int y){
        return x > 0 && x <= n && y > 0 && y <= n;
    }
}//class end
