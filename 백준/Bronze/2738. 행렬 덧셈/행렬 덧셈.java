import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        for(int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int x=0; x<n; x++){
            for(int y=0; y<m; y++){
                b[x][y] = sc.nextInt();
            }
        }
        for(int k =0; k<n; k++){
            for(int q = 0; q<m; q++){
                System.out.print(a[k][q]+b[k][q]+" ");
            }
            System.out.println();
        }
    }
}