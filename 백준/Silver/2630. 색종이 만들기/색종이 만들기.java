import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int white = 0;
    private static int blue = 0;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        partition(0,0,n);

        System.out.println(white);
        System.out.println(blue);
    }//main end
    
    private static void partition(int x, int y, int size) {
        if(colorCheck(x,y,size)){
            if(map[x][y] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }
        
        int newSize = size/2;
        partition(x, y, newSize);
        partition(x, y + newSize, newSize);
        partition(x+newSize, y, newSize);
        partition(x+newSize, y+newSize, newSize);
    }//partition end
    
    private static boolean colorCheck(int x, int y, int size) {
        int color = map[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(color != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}//class end
