

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        System.out.println(search(0,max));
    }//main end

    private static long search(int min,int max){
        if(min > max){
            return max;
        }

        int mid = (min + max)/2;
        long sum = cut(mid);

        if(sum < m){
            return search(min,mid-1);
        }else{
            return search(mid+1,max);
        }
    }//search end

    private static long cut(long mid){
        long sum = 0;
        for(int i : arr){
            if(i > mid){
                sum += (i-mid);
            }
        }
        return sum;
    }//cut end
}//class end
