import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        int size = n*n;
        int[] ab = new int[size];
        int[] cd = new int[size];

        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ab[idx] = a[i] + b[j];
                cd[idx] = c[i] + d[j];
                idx++;
            }
        }

        Arrays.sort(cd);

        long answer = 0;
        for(int i = 0; i < size; i++){
            int target = -ab[i];

            answer += upperCase(cd,target) - lowerCase(cd,target);
        }

        System.out.println(answer);
    }//main end

    private static int upperCase(int[] arr,int target){
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }//upperCase end

    private static int lowerCase(int[] arr,int target){
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }//lowerCase end
}//class end
