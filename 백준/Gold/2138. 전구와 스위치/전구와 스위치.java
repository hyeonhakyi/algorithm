import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static char[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        int ans1 = simulate(arr.clone(),true);
        int ans2 = simulate(arr.clone(),false);

        if(ans1 == -1 && ans2 == -1){
            System.out.println(-1);
        }else if (ans1 == -1){
            System.out.println(ans2);
        }else if(ans2 == -1){
            System.out.println(ans1);
        }else{
            System.out.println(Math.min(ans1,ans2));
        }
    }

    static int simulate(char[] arr,boolean flag){
        int cnt = 0;

        if(flag){
            cnt++;
            press(arr,0);
            press(arr,1);
        }

        for(int i = 1; i < n; i++){
            if(arr[i - 1] != target[i - 1]){
                cnt++;
                press(arr,i - 1);
                press(arr,i);
                if(i +1 < n) press(arr,i+1);
            }
        }

        if(Arrays.equals(arr,target)) return cnt;
        return -1;
    }

    static void press(char[] arr,int idx){
        arr[idx] = arr[idx] == '0' ? '1' : '0';
    }
}//class end
