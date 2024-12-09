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
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m,sx,sy;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine(); // 한 줄 입력
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j); // 공백 없이 바로 문자 저장
                if (arr[i][j] == 'I') {
                    sx = i;
                    sy = j;
                }
            }
        }

        int result = find();
        if(result == 0){
            System.out.println("TT");
        }else {
            System.out.println(result);
        }
    }

    private static int find(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy));
        visited[sx][sy] = true;
        int answer = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(!check(nx,ny) || visited[nx][ny] || arr[nx][ny] == 'X'){
                    continue;
                }

                visited[nx][ny] = true;

                if(arr[nx][ny] == 'O'){
                    q.offer(new Node(nx, ny));
                }else if(arr[nx][ny] == 'P'){
                    answer++;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return answer;
    }

    private static boolean check(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
