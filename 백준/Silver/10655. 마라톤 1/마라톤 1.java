import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,totalDistance;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if(i >= 1){
                totalDistance += Math.abs(arr[i][0] - arr[i-1][0]) + Math.abs(arr[i][1] - arr[i-1][1]);
            }
        }

        for(int i = 1; i < n-1; i++) {
            int originalDistance = Math.abs(arr[i][0] - arr[i-1][0])
                                + Math.abs(arr[i][1] - arr[i-1][1])
                                + Math.abs(arr[i][0] - arr[i+1][0])
                                + Math.abs(arr[i][1] - arr[i+1][1]);
            int skippedDistance = Math.abs(arr[i-1][0] - arr[i+1][0])
                                + Math.abs(arr[i-1][1] - arr[i+1][1]);

            result = Math.min(result, totalDistance - originalDistance + skippedDistance);
        }
        System.out.println(result);
    }
}
