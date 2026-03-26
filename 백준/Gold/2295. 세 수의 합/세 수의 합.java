import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int num = arr[i] + arr[j];
                map.put(num,map.getOrDefault(num,0) + 1);
            }
        }

        int answer = 0;
        boolean check = false;
        for(int i = n - 1; i > 0; i--){
            if(check) break;
            for(int j = i; j >= 0; j--){
                int num = arr[i] - arr[j];
                if(map.containsKey(num)){
                    answer = arr[i];
                    check = true;
                    break;
                }
            }
        }

        System.out.println(answer);
    }//main end
}//class end
