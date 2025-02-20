
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, x, y,leftArm, rightArm, leftLeg, rightLeg,waist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == '*') {
                    if(findHeart(i,j)){
                        x = i;
                        y = j;
                    };
                }
            }
        }

        //왼팔
        int n1 = x;
        int n2 = y -1;
        while(!check(n1,n2) && arr[n1][n2] == '*') {
            leftArm++;
            n2--;
        }

        //오른팔
        n1 = x;
        n2 = y + 1;
        while(!check(n1,n2) && arr[n1][n2] == '*') {
            rightArm++;
            n2++;
        }

        //허리
        int x1 = x + 1;
        int x2 = y;
        while(!check(x1,x2) && arr[x1][x2] == '*') {
            waist++;
            x1++;
        }

        //왼 다리
        n1 = x1 + 1;
        n2 = x2 - 1;
        leftLeg = 1;
        while(!check(n1,n2) && arr[n1][n2] == '*') {
            leftLeg++;
            n1++;
        }

        //오른 다리
        n1 = x1 + 1;
        n2 = x2 + 1;
        rightLeg = 1;
        while(!check(n1,n2) && arr[n1][n2] == '*') {
            rightLeg++;
            n1++;
        }

        System.out.println((x+1) + " " + (y+1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }//main end

    static boolean findHeart(int x,int y){
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(check(nx,ny)){
                return false;
            }

            if(arr[nx][ny] != '*') {
                return false;
            }
        }
        return true;
    }//findHeart end

    static boolean check(int x,int y){
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}//class end
