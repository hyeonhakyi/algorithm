import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    static boolean check;
    static int n,l,r;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        int day = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            check = false;
            visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]){
                        bfs(i, j);
                    }
                }
            }
            if(!check){
                break;
            }else{
                day++;
            }
        }
        System.out.println(day);
    }//main end

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        list.add(new Node(x,y));
        int diff = 0;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(isCheck(nx,ny)){
                    diff = Math.abs(arr[now.x][now.y] - arr[nx][ny]);
                    if(l <= diff && diff <= r){
                        if(!visited[nx][ny]){
                            check = true;
                            q.offer(new Node(nx,ny));
                            visited[nx][ny] = true;
                            list.add(new Node(nx,ny));
                        }
                    }
                }
            }
        }
        isPrice();
    }//bfs end

    private static void isPrice(){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            Node node = list.get(i);
            sum += arr[node.x][node.y];
        }
        for(int i = 0; i < list.size(); i++){
            Node node = list.get(i);
            arr[node.x][node.y] = sum/list.size();
        }
        list.clear();
    }//isPrice end

    private static boolean isCheck(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }//isCheck end
}//class end
