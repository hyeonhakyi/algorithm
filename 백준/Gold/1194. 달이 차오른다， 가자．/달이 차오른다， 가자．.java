import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int x;
        int y;
        int value;
        int key;
        public Node(int x,int y,int value,int key){
            this.x = x;
            this.y = y;
            this.value = value;
            this.key = key;
        }
    }
    private static int n,m;
    private static char[][] arr;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m][64];

        int startX = 0;
        int startY = 0;
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == '0'){
                    startX = i;
                    startY = j;
                }
            }
        }
        bfs(startX,startY);
    }//main end

    private static void bfs(int x,int y){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x,y,0,0));
        visited[x][y][0] = true;

        while(!que.isEmpty()){
            Node now = que.poll();
            int nowX = now.x;
            int nowY = now.y;
            int value = now.value;

            if(arr[nowX][nowY] == '1'){
                System.out.println(value);
                return;
            }

            for(int d = 0; d < 4; d++){
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] != '#' && !visited[nx][ny][now.key]){
                    if(arr[nx][ny] >= 'a' && arr[nx][ny] <= 'z'){
                        int key = now.key | (1 << (arr[nx][ny] - 'a'));
                        que.offer(new Node(nx,ny,value+1,key));
                        visited[nx][ny][key] = true;
                    }else if(arr[nx][ny] >= 'A' && arr[nx][ny] <= 'Z'){
                        boolean check = (now.key & (1 << (arr[nx][ny] - 'A')))!= 0;
                        if(check){
                            que.offer(new Node(nx,ny,value+1, now.key));
                            visited[nx][ny][now.key] = true;
                        }
                    }else{
                        que.offer(new Node(nx,ny,value+1,now.key));
                        visited[nx][ny][now.key] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }//bfs end
}//class end
