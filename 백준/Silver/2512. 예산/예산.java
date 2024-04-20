
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int hight = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if(hight < arr[i]){
                hight = arr[i];
            }
        }

        int m = Integer.parseInt(br.readLine());
        
        if(sum <= m){
            System.out.println(hight);
            return;
        }

        int min = 1;
        while(min < hight - 1){
            int mid = (min + hight)/2;
            
            if(cal(mid) > m){
                hight = mid;
            }else{
                min = mid;
            }
        }
        System.out.println(min);
    }//main end
    
    private static int cal(int mid){
        int total = 0;
        for(int i = 0; i < n; i++){
            total += Math.min(mid,arr[i]);
        }
        return total;
    }
}//class end
