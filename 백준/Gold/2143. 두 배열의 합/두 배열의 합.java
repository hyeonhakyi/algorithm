import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> sumA = new ArrayList<>();
        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = i; j < n; j++){
                sum += a[j];
                sumA.add(sum);
            }
        }

        ArrayList<Long> sumB = new ArrayList<>();
        for(int i = 0; i < m; i++){
            long sum = 0;
            for(int j = i; j < m; j++){
                sum += b[j];
                sumB.add(sum);
            }
        }

        Collections.sort(sumB);

        long answer = 0;
        for(long A : sumA){
            long target = t - A;

            int lower = lowerCase(sumB,target);
            int upper = upperCase(sumB,target);

            answer += (upper - lower);
        }

        System.out.println(answer);
    }//main end

    static int lowerCase(ArrayList<Long> b,long target){
        int l = 0;
        int r = b.size();

        while(l < r){
            int mid = (l + r) / 2;
            if(b.get(mid) >= target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }//lowerCase end

    static int upperCase(ArrayList<Long> b,long target){
        int l = 0;
        int r = b.size();
        while(l < r){
            int mid = (l + r) / 2;
            if(b.get(mid) > target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }//upperCase end
}//class end
