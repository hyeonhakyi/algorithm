import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        x = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = n;
        int answer = 0;
        while(left <= right){
            int mid = (left + right)/2;

            if(check(mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }//main end

    private static boolean check(int h){
        int cover = 0;
        for(int arr : x){
            if(arr - h > cover){
                return false;
            }
            cover = arr + h;
        }
        return cover >= n;
    }//check end
}//class end
