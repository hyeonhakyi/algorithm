import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Monkey{
        int x;
        int y;
        int k;
        int count;

        public Monkey(int x,int y,int k, int count){
            this.x = x;
            this.y = y;
            this.k = k;
            this.count = count;
        }
    }
    static int k,w,h;
    static int[][] arr;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        visited = new boolean[h][w][31];

        for(int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0][0] = true;

        bfs(0,0,k,0);

    }//main end

    private static int[] horseDx = {-1,-2,-2,-1,1,2,2,1};
    private static int[] horseDy = {-2,-1,1,2,2,1,-1,-2};
    private static int[] monkeyDx = {-1,1,0,0};
    private static int[] monkeyDy = {0,0,-1,1};
    private static void bfs(int newX, int newY, int newK, int newCount){
        Queue<Monkey> que = new LinkedList<>();
        que.offer(new Monkey(newX,newY,newK,newCount));

        while(!que.isEmpty()){
            Monkey monkey = que.poll();
            int x = monkey.x;
            int y = monkey.y;
            int k = monkey.k;
            int count = monkey.count;

            if(x == h-1 && y == w-1){
                System.out.println(count);
                return;
            }

            if(x < 0 || y < 0 || x >= h || y >= w) continue;
            if(arr[x][y] == 1)continue;
            if(visited[x][y][k])continue;
            visited[x][y][k] = true;

            for(int d = 0; d < 4; d++){
                int nx = x + monkeyDx[d];
                int ny = y + monkeyDy[d];

                que.offer(new Monkey(nx,ny,k,count+1));
            }

            if(k == 0)continue;

            for(int d = 0; d < 8; d++){
                int nx = x + horseDx[d];
                int ny = y + horseDy[d];

                que.offer(new Monkey(nx,ny,k-1,count+1));
            }
        }
        System.out.println(-1);
    }
}//class end
