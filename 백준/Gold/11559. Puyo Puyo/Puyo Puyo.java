import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
    private static char[][] arr = new char[12][6];
    private static boolean[][] visited;
    private static Queue<Node> que = new LinkedList<>();
    private static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 12; i++){
            String s = br.readLine();
            for(int j = 0; j < 6; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int count = 0;
        while(true){
            boolean isCheck = false;
            visited = new boolean[12][6];
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(arr[i][j] != '.'){
                        list = new ArrayList<>();
                        bfs(i,j,arr[i][j]);


                        if(list.size() >= 4){
                            isCheck = true;
                            for(int k = 0; k < list.size(); k++) {
                                arr[list.get(k).x][list.get(k).y] = '.';
                            }
                        }
                    }
                }
            }
            if(!isCheck)break;
            down();
            count++;
        }//while end

        System.out.println(count);
    }//main end

    private static void bfs(int x,int y,char cal){
        list.add(new Node(x,y));
        que.offer(new Node(x,y));
        visited[x][y] = true;

        while(!que.isEmpty()){
            Node now = que.poll();

            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(check(nx,ny) && cal == arr[nx][ny] && !visited[nx][ny]){
                    list.add(new Node(nx,ny));
                    que.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }//bfs end

    private static void down(){
        for(int i = 0; i < 6; i++){
            for(int j = 11; j > 0; j--){
                if(arr[j][i] == '.'){
                    for(int k = j - 1; k >= 0; k--){
                        if(arr[k][i] != '.'){
                            arr[j][i] = arr[k][i];
                            arr[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }//down end


    private static boolean check(int x,int y){
        return x >= 0 && y >= 0 && x < 12 && y < 6;
    }
}//class end
