import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        int allMax = Integer.MIN_VALUE;
        int allMin = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            allMax = Math.max(allMax, arr[i]);
            allMin = Math.min(allMin, arr[i]);
        }

        int left = 0;
        int right = allMax - allMin;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            if(can(mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }//main end

    private static boolean can(int mid){
        int count = 1;
        int max = arr[0];
        int min = arr[0];

        for(int i = 0; i < n; i++){
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);

            if(max - min > mid){
                count++;
                max = arr[i];
                min = arr[i];
            }
        }
        return count <= m;
    }//can end
}//class end
