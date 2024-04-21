import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int count;
        public Node(int x,int y,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if(this.count == o.count){
                if(this.x == o.x){
                    return this.y - o.y;
                }else{
                    return this.x - o.x;
                }
            }else{
                return this.count - o.count;
            }
        }
    }
    private static int n,m,k;
    private static int curX,curY,curC;
    private static int[][] arr;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        curX = Integer.parseInt(st.nextToken())-1;
        curY = Integer.parseInt(st.nextToken())-1;

        for(int i = 2; i < m+2; i++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken())-1;
            int sy = Integer.parseInt(st.nextToken())-1;
            int ex = Integer.parseInt(st.nextToken())-1;
            int ey = Integer.parseInt(st.nextToken())-1;

            arr[sx][sy] = i;
            list.add(new Node(ex,ey,0));
        }

        int count = 0;
        while (count != m){
            int temp1 = searchPerson();
            if(k - temp1 <= 0|| temp1 == -1){
                break;
            }

            int temp2 = searchPosition();
            if(k - (temp1+temp2) < 0 || temp2 == -1){
                break;
            } else{
                k += temp2 - temp1;
            }
            count++;
        }
        if(count == m){
            System.out.println(k);
        }else{
            System.out.println(-1);
        }
    }//main end

    private static int searchPerson(){
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        que.offer(new Node(curX,curY,0));
        visited[curX][curY] = true;

        while(!que.isEmpty()){
            Node now = que.poll();

            if(arr[now.x][now.y] > 1){
                curC = arr[now.x][now.y];
                curX = now.x;
                curY = now.y;
                arr[curX][curY] = 0;
                return now.count;
            }


            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx,ny))continue;
                if(visited[nx][ny])continue;
                if(arr[nx][ny] == 1)continue;

                que.offer(new Node(nx,ny,now.count+1));
                visited[nx][ny] = true;
            }
        }
        return -1;
    }//searchPerson end

    private static int searchPosition(){
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        que.offer(new Node(curX,curY,0));
        visited[curX][curY] = true;

        int ex = list.get(curC - 2).x;
        int ey = list.get(curC - 2).y;
        while(!que.isEmpty()){
            Node now = que.poll();

            if(now.x == ex && now.y == ey){
                curX = now.x;
                curY = now.y;
                return now.count;
            }


            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!check(nx,ny))continue;
                if(visited[nx][ny])continue;
                if(arr[nx][ny] == 1)continue;

                que.offer(new Node(nx,ny,now.count+1));
                visited[nx][ny] = true;
            }
        }
        return -1;
    }//searchPerson end


    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}//class end
