import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = br.readLine();
        int sum = 0;

        char[] arr = n.toCharArray();
        Arrays.sort(arr);


        for(int i = arr.length - 1 ; i >= 0; i--) {
            sum += arr[i] - '0';
            sb.append(arr[i]-'0');
        }

        if(arr[0] != '0' || sum%3 != 0){
            System.out.println(-1);
            return;
        }
        System.out.println(sb.toString());
    }
}
