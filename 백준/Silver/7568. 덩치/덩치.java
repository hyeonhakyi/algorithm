import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            arr[i][0] = weight;
            arr[i][1] = height;
        }

        for(int i = 0; i < n; i++){
            int count = 1;
            for(int j = 0; j < n; j++){
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    count++;
                }
            }
            System.out.print(count + " ");
        }

    }//main end
}//class end
