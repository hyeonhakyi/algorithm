import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] title = new String[n];
        int[] numbers = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = (st.nextToken());    
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int idx = binarySearch(numbers, num);
            sb.append(title[idx]).append("\n");
        }

        System.out.println(sb.toString());
    }//main end

    private static int binarySearch(int[] numbers, int num) {
        int left = 0;
        int right = numbers.length - 1;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(num <= numbers[mid]){
                result = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return result;
    }//binarySearch end
}//class end
