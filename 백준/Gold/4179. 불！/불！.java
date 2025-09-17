import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Fire{
        int x;
        int y;
        public Fire(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int r,c;
    static Queue<Node> per = new LinkedList<>();
    static Queue<Fire> fire = new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'J'){
                    per.add(new Node(i, j));
                }else if(arr[i][j] == 'F'){
                    fire.add(new Fire(i,j));
                }
            }
        }

        bfs();
    }//main end

    static void bfs() {
        int count = 0;
        while(true){
            count++;

            int fireSize = fire.size();
            while(fireSize > 0){
                fireSize--;
                Fire f = fire.poll();

                for(int d = 0; d < 4; d++) {
                    int nx = f.x + dx[d];
                    int ny = f.y + dy[d];

                    if(check(nx,ny)){
                        if(arr[nx][ny] == 'J' || arr[nx][ny] == '.'){
                            fire.add(new Fire(nx, ny));
                            arr[nx][ny] = 'F';
                        }
                    }
                }
            }//fire end

            int perSize = per.size();
            while(perSize > 0){
                perSize--;
                Node p = per.poll();

                for(int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if(!check(nx,ny)){
                        System.out.println(count);
                        return;
                    }

                    if(check(nx,ny) && arr[nx][ny] == '.'){
                        per.add(new Node(nx, ny));
                        arr[nx][ny] = 'F';
                    }
                }
            }//person end

            if(per.isEmpty()){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }//bfs end

    static boolean check(int x,int y){
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}//class end
