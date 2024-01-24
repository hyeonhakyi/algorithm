import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i< n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for(int x = 0; x < n; x++){
            int count = 1;
            for(int y = 0; y < n; y++){
                if(x==y){
                    continue;
                }
                if(arr[x][0]<arr[y][0] && arr[x][1] < arr[y][1]) {
                    count++;
                }
            }
            System.out.print(count+" ");
        }
    }
}