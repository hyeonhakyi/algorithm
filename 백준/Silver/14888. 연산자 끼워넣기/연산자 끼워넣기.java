import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,max,min;
    static int[] arr;
    static int[] operation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        operation = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i]  = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operation[i] = Integer.parseInt(st.nextToken());
        }

        combi(arr[0],1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void combi(int num, int idx){
        if(idx == n){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        for(int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                switch (i) {
                    case (0):
                        combi(num + arr[idx], idx + 1);
                        break;
                    case (1):
                        combi(num - arr[idx], idx + 1);
                        break;
                    case (2):
                        combi(num * arr[idx], idx + 1);
                        break;
                    case (3):
                        combi(num / arr[idx], idx + 1);
                        break;
                }
                operation[i]++;
            }
        }
    }
}
