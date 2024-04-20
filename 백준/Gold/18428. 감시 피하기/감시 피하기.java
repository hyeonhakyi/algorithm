import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    private static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int n;
    private static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0);
        System.out.println("NO");
    }//main end

    private static void dfs(int count){
        if(count == 3){
            if(bfs()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 'X'){
                    arr[i][j] = 'O';
                    dfs(count+1);
                    arr[i][j] = 'X';
                }
            }
        }
    }//dfs end

    private static boolean bfs(){
        Queue<Node> que = new LinkedList<>();
        char[][] copy = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                copy[i][j] = arr[i][j];

                if(copy[i][j] == 'T'){
                    que.offer(new Node(i,j));
                }
            }
        }

        while (!que.isEmpty()){
            Node now = que.poll();

            for(int d = 0; d < 4; d++){
                int nx = now.x;
                int ny = now.y;

                while (true){
                    nx += dx[d];
                    ny += dy[d];

                    if(!check(nx,ny))break;
                    if(copy[nx][ny] == 'O')break;
                    if(copy[nx][ny] == 'S')return false;
                }
            }
        }
        return true;
    }//bfs end

    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }//check end
}//class end
