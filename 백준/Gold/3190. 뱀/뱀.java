import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,k,l;
    static int r,c;
    static int[][] arr;
    static List<int[]> snake;
    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];

        snake = new LinkedList<int[]>();
        snake.add(new int[] {1,1});


        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr[r][c] = 1;
        }

        l = Integer.parseInt(br.readLine());
        Map<Integer,String> dir = new HashMap<>();
        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            dir.put(Integer.parseInt(st.nextToken()),st.nextToken());
        }
        int time = dfs(1,1,0,dir);

        System.out.println(time);
    }

    private static int dfs(int x, int y, int nowDir,Map<Integer,String> dir){
        int time = 0;

        while(true){
            time++;

            int nx = x + dx[nowDir];
            int ny = y + dy[nowDir];

            //범위 벗어남
            if(nx < 1 || ny < 1 || nx >= n+1 || ny >= n+1){
                break;
            }

            for(int i = 0; i < snake.size(); i++){
                if(nx == snake.get(i)[0] && ny == snake.get(i)[1]){
                    return time;
                }
            }

            if(arr[nx][ny] == 1){
                arr[nx][ny] = 0;
                snake.add(new int[] {nx,ny});
            }else{
                snake.add(new int[] {nx,ny});
                snake.remove(0);
            }

            x = nx;
            y = ny;

            if(dir.containsKey(time)){
                if(dir.get(time).equals("D")){
                    nowDir++;
                    if(nowDir == 4){
                        nowDir = 0;
                    }
                }else if(dir.get(time).equals("L")){
                    nowDir--;
                    if(nowDir == -1){
                        nowDir = 3;
                    }
                }
            }
        }
        return time;
    }
}
