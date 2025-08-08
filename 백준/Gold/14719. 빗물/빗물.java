import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];

        int maxHeight = 0;
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            if(arr[i] > maxHeight){
                maxHeight = arr[i];
                idx = i;
            }
        }

        int answer = 0;

        int max = 0;
        for(int i = 0; i < idx; i++){
            if(max == 0){
                max = arr[i];
            }else if(arr[i] > max){
                max = arr[i];
            }else if(arr[i] < max){
                answer += (max - arr[i]);
            }
        }

        max = 0;
        for(int i = w - 1; i > idx; i--){
            if(max == 0){
                max = arr[i];
            }else if(arr[i] > max){
                max = arr[i];
            }else if(arr[i] < max){
                answer += (max - arr[i]);
            }
        }

        System.out.println(answer);
    }//main end
}//class end
