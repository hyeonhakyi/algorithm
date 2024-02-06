
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n,m,c;
    private static int[][] map;
    private static int[][] temp;
    public static void upDown(){
        temp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                temp[n-i-1][j] = map[i][j];
            }
        }
        map = temp;
    }
    public static void leftRight(){
        temp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                temp[i][m-j-1] = map[i][j];
            }
        }
        map = temp;
    }
    public static void right(){
        temp = new int[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                temp[j][n-i-1] = map[i][j];
            }
        }
        int tmp = n;
        n = m;
        m = tmp;

        map = temp;
    }
    public static void left(){
        temp = new int[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                temp[m-j-1][i] = map[i][j];
            }
        }
        int tmp = n;
        n = m;
        m = tmp;

        map = temp;
    }

    public static void oneTwo(){
        temp = new int[n][m];
        //1 -> 2
        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                temp[i][m/2+j] = map[i][j];
            }
        }
        // 2 -> 3
        for(int i=0; i<n/2; i++){
            for(int j=m/2; j<m; j++){
                temp[n/2+i][j] = map[i][j];
            }
        }
        // 3 -> 4
        for(int i=n/2; i<n; i++){
            for(int j=m/2; j<m; j++){
                temp[i][j-m/2] = map[i][j];
            }
        }
        // 4 -> 1
        for(int i=n/2; i<n; i++){
            for(int j=0; j<m/2; j++){
                temp[i-n/2][j] = map[i][j];
            }
        }
        map = temp;

    }

    public static void oneFor(){
        temp = new int[n][m];
        // 1 -> 4
        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                temp[n/2+i][j] = map[i][j];
            }
        }
        // 4 -> 3
        for(int i=n/2; i<n; i++){
            for(int j=0; j<m/2; j++){
                temp[i][j+m/2] = map[i][j];
            }
        }
        // 3 -> 2
        for(int i=n/2; i<n; i++){
            for(int j=m/2; j<m; j++){
                temp[i-n/2][j] = map[i][j];
            }
        }
        // 2 -> 1
        for(int i=0; i<n/2; i++){
            for(int j=m/2; j<m; j++){
                temp[i][j-m/2] = map[i][j];
            }
        }
        map = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++) {
            int num = Integer.parseInt(st.nextToken());
            switch (num) {
                case 1:
                    upDown();
                    break;
                case 2:
                    leftRight();
                    break;
                case 3:
                    right();
                    break;
                case 4:
                    left();
                    break;
                case 5:
                    oneTwo();
                    break;
                case 6:
                    oneFor();
                    break;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
