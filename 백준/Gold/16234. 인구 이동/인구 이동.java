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
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,l,r;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true){
            visited = new boolean[n][n];
            boolean isMove = false;

            for(int i = 0; i < n;  i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j]){
                        if(bfs(i,j)){
                            isMove = true;
                        }
                    }
                }
            }

            if(!isMove) break;
            day++;
        }
        System.out.println(day);
    }//main end

    static boolean bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        List<Node> list = new ArrayList<>();

        q.offer(new Node(x,y));
        list.add(new Node(x,y));
        visited[x][y] = true;
        int sum = arr[x][y];

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx,ny)) continue;
                if(visited[nx][ny]) continue;

                int diff = Math.abs(arr[now.x][now.y] - arr[nx][ny]);
                if(l <= diff && r >= diff){
                    q.offer(new Node(nx,ny));
                    list.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                    sum += arr[nx][ny];
                }
            }
        }

        if(list.size() == 1) return false;

        int newValue = sum / list.size();
        for(Node i:list){
            arr[i.x][i.y] = newValue;
        }
        return true;
    }//bfs end

    static boolean check(int x,int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}//class end
