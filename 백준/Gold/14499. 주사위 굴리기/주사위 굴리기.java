import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,x,y,k;
    static int[][] arr;
    static int[] dx = {0,0,0,-1,1};
    static int[] dy = {0,1,-1,0,0};
    static int[] dice;
    static int cx,cy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dice = new int[7];


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            int d = Integer.parseInt(st.nextToken());

            move(d);
        }
    }

    static void move(int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
            roll(d,nx,ny);
            x = nx;
            y = ny;
        }
    }



    static void roll(int d, int x, int y) {
        int tmp = dice[3];
        switch(d) {
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
             break;
             case 4:
                 dice[3] = dice[1];
                 dice[1] = dice[6];
                 dice[6] = dice[5];
                 dice[5] = tmp;
                 break;
            }
            if(arr[x][y] == 0) {
                arr[x][y] = dice[6];
            } else {
                dice[6] = arr[x][y];
                arr[x][y] =0;
            }
            System.out.println(dice[3]);
     }
}

