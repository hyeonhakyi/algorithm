import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[n];
        int size = 0;

        for(int i = 0; i < n; i++){
            int x = arr[i];

            int left = 0;
            int right = size;

            while(left < right){
                int mid = (left + right) / 2;

                if(lis[mid] >= x){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }

            lis[left] = x;

            if(left == size){
                size++;
            }
        }

        System.out.println(size);
    }//main end
}//class end
