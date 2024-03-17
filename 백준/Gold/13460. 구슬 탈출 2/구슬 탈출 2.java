import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    private static class Ball{
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;
        public Ball(int rx,int ry,int bx,int by,int cnt){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
    private static int n,m,result;
    private static int[][] map;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = Integer.MAX_VALUE;

        Ball balls = new Ball(0,0,0,0,0);

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);

                if(map[i][j] == 'R'){
                    balls.rx = i;
                    balls.ry = j;
                    map[i][j] = '.';
                }else if(map[i][j] == 'B'){
                    balls.bx = i;
                    balls.by = j;
                    map[i][j] = '.';
                }
            }
        }

        bfs(balls);
        System.out.println(result);
    }//main end

    private static void bfs(Ball balls){
        Queue<Ball> que = new LinkedList<>();
        que.offer(balls);

        while(!que.isEmpty()){
            Ball ball = que.poll();

            if(ball.cnt == 10){
                continue;
            }

            for(int d = 0; d < 4; d++){
                int redX = ball.rx;
                int redY = ball.ry;
                int blueX = ball.bx;;
                int blueY = ball.by;
                boolean isRed = false;
                boolean isBlue = false;

                while(true){
                    int nxRed = redX + dx[d];
                    int nyRed = redY + dy[d];

                    if(map[nxRed][nyRed] == '#'){
                        break;
                    }

                    if(map[nxRed][nyRed] == 'O'){
                        isRed = true;
                        break;
                    }

                    redX = nxRed;
                    redY = nyRed;
                }

                while(true){
                    int nxBlue = blueX + dx[d];
                    int nyBlue = blueY + dy[d];

                    if(map[nxBlue][nyBlue] == '#'){
                        break;
                    }

                    if(map[nxBlue][nyBlue] == 'O'){
                        isBlue = true;
                        break;
                    }

                    blueX = nxBlue;
                    blueY = nyBlue;
                }

                if(isBlue){
                    continue;
                } else if (isRed) {
                    ball.cnt += 1;
                    result = ball.cnt;
                    return;
                }

                if(ball.rx == redX && ball.ry == redY && ball.bx == blueX && ball.by == blueY){
                    continue;
                }

                if(redX == blueX && redY == blueY){
                    if(d == 0){
                        if(ball.rx > ball.bx){
                            redX++;
                        }else{
                            blueX++;
                        }
                    }else if(d == 1){
                        if(ball.rx > ball.bx){
                            blueX--;
                        }else{
                            redX--;
                        }
                    }else if(d == 2){
                        if(ball.ry > ball.by){
                            redY++;
                        }else{
                            blueY++;
                        }
                    }else{
                        if(ball.ry > ball.by){
                            blueY--;
                        }else{
                            redY--;
                        }
                    }
                }
                que.offer(new Ball(redX,redY,blueX,blueY,(ball.cnt)+1));
            }
        }
        result = -1;
        return;
    }//bfs end
}//class end

