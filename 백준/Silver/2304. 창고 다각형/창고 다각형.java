import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] height = new int[1001];

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            height[l] = h;
            start = Math.min(start,l);
            end = Math.max(end,l);
        }

        int maxIdx = 0;
        int maxHeight = 0;
        for(int i = start; i <= end; i++){
            if(height[i] > maxHeight){
                maxHeight = height[i];
                maxIdx = i;
            }
        }

        int answer = 0;
        int current = 0;
        for(int i = start; i <= maxIdx; i++){
            current = Math.max(height[i],current);
            answer += current;
        }
        
        current = 0;
        for(int i = end; i > maxIdx; i--){
            current = Math.max(height[i],current);
            answer += current;
        }

        System.out.println(answer);
    }//main end
}//class end
