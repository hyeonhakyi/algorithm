import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,1,1,1,0,0,0,-1,-1,-1};
    static int[] dy = {0,-1,0,1,-1,0,1,-1,0,1};
    static char[][] arr;
    static int sx,se,r,c;
    static List<Node> craze = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for(int i = 0; i < r; i++){
            String line = br.readLine();
            for(int j = 0; j < c; j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'I'){
                    sx = i;
                    se = j;
                }else if(arr[i][j] == 'R'){
                    craze.add(new Node(i,j));
                }
            }
        }

        String moves = br.readLine();
        for(int i = 0; i < moves.length(); i++) {
            int dir = moves.charAt(i) - '0';

            int nx = sx + dx[dir];
            int ny = se + dy[dir];

            if(arr[nx][ny] == 'R'){
                System.out.println("kraj " + (i + 1));
                return;
            }

            arr[sx][se] = '.';
            sx = nx;
            se = ny;
            arr[nx][ny] = 'I';

            int[][] cnt = new int[r][c];
            List<Node> next = new ArrayList<>();

            for(Node craz : craze){
                int min = Integer.MAX_VALUE;
                int mx = 0;
                int my = 0;

                for(int d = 1; d <= 9; d++){
                    int cx = craz.x + dx[d];
                    int cy = craz.y + dy[d];
                    int dist = Math.abs(cx - sx) + Math.abs(cy - se);

                    if(dist < min){
                        min = dist;
                        mx = cx;
                        my = cy;
                    }
                }

                if(mx == sx && my == se){
                    System.out.println("kraj " + (i + 1));
                    return;
                }

                cnt[mx][my]++;
                next.add(new Node(mx,my));
            }//craze end

            craze.clear();
            for(Node n : next){
                if(cnt[n.x][n.y] == 1){
                    craze.add(n);
                }
            }

            for(int x = 0; x < r; x++){
                for(int y = 0; y < c; y++){
                    if(arr[x][y] == 'R'){
                        arr[x][y] = '.';
                    }
                }
            }

            for(Node n : craze){
                arr[n.x][n.y] = 'R';
            }
        }//simulate

        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < r; x++){
            sb.append(arr[x]).append("\n");
        }
        System.out.println(sb.toString());
    }//main end
}//class end
