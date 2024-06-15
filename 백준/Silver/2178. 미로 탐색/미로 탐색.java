import java.io.*;
import java.util.*;


public class Main {
    static int N,M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            String s  = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;
        BFS(0,0);
        System.out.println(arr[N-1][M-1]);

    }


    public static void BFS(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {x,y});

        while(!que.isEmpty()){
            int[] now = que.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(visited[nextX][nextY] || arr[nextX][nextY] == 0) continue;

                que.add(new int[] {nextX,nextY});
                arr[nextX][nextY] = arr[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }

        }

    }
}
