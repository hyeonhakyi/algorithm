import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * r행 c열 비어있으면. 물이 차있으면* 돌은X 비버굴D 고슴도치는S
 * 물도 확장 고슴도치도 이동 돌을 통과 못함 고슴도치는 물로 이동 못함 물도 비버굴 못감
 * 고슴도치가 비버굴로 이동하기 위한 최소 시간
 * 다음 시간에 물이 찰 예정인 곳에 고슴도치는 못 이동함
 * */

public class Main {
    private static class animal{
        int x;
        int y;
        int count;
        public animal(int x,int y,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    private static class water{
        int x;
        int y;
        public water(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int r,c,endX,endY,result;
    private static char[][] arr;
    private static Queue<water> waters = new LinkedList<>();
    private static Queue<animal> animals = new LinkedList<>();
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c];
        endX = 0;
        endY = 0;
        result = Integer.MAX_VALUE;

        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(arr[i][j] == 'D'){
                    endX = i;
                    endY = j;
                }else if(arr[i][j] == 'S'){
                    animals.offer(new animal(i,j,0));
                }else if(arr[i][j] == '*'){
                    waters.offer(new water(i,j));
                }
            }
        }

        bfs();
        if(result == Integer.MAX_VALUE){
            System.out.println("KAKTUS");
        }else{
            System.out.println(result);
        }
    }//main end

    private static void bfs(){
        while(!animals.isEmpty()) {
            int len = waters.size();
            for(int i = 0; i < len; i++) {
                water now = waters.poll();
                int nowWaterX = now.x;
                int nowWaterY = now.y;

                for (int d = 0; d < 4; d++) {
                    int nxWater = nowWaterX + dx[d];
                    int nyWater = nowWaterY + dy[d];

                    if (nxWater >= 0 && nyWater >= 0 && nxWater < r && nyWater < c && arr[nxWater][nyWater] == '.') {
                        arr[nxWater][nyWater] = '*';
                        waters.offer(new water(nxWater, nyWater));
                    }
                }
            }

            len = animals.size();
            for(int i = 0; i < len; i++) {
                animal mou = animals.poll();
                int nowMouseX = mou.x;
                int nowMouseY = mou.y;
                int count = mou.count;

                for (int d = 0; d < 4; d++) {
                    int nxMouse = nowMouseX + dx[d];
                    int nyMouse = nowMouseY + dy[d];

                    if (nxMouse >= 0 && nyMouse >= 0 && nxMouse < r && nyMouse < c && (arr[nxMouse][nyMouse] == '.' || arr[nxMouse][nyMouse] == 'D')) {
                        if (arr[nxMouse][nyMouse] == 'D') {
                            result = Math.min(result,count+1);
                            return;
                        }else if(arr[nxMouse][nyMouse] =='.'){
                            arr[nxMouse][nyMouse] = 'S';
                            animals.offer(new animal(nxMouse, nyMouse, count + 1));
                        }
                    }
                }
            }
        }
    }//bfs end
}//class end
