import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    static int n,count=0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        nQueen(0);
        System.out.println(count);
    }

    static void nQueen(int depth){
        if(depth == n){
            count++;
            return;
        }

        for(int i = 0; i <n; i++){
            arr[depth] = i;

            if(Possiblity(depth)){
                nQueen(depth+1);
            }
        }
    }

    static boolean Possiblity(int col){
        for(int i = 0; i < col; i++){
            if(arr[col] == arr[i]){
                return false;
            } else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
