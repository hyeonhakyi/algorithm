
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] max = new int[3];
        int[] min = new int[3];
        int[] curMax = new int[3];
        int[] curMin = new int[3];
        int[] input = new int[3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            input[2] = Integer.parseInt(st.nextToken());

            if(i == 0){
                max = input.clone();
                min = input.clone();
                curMax = input.clone();
                curMin = input.clone();
            }else{
                curMax[0] = Math.max(max[0], max[1]) + input[0];
                curMax[2] = Math.max(max[1], max[2]) + input[2];
                int curMaxValue = Math.max(max[0], max[1]);
                curMaxValue = Math.max(curMaxValue, max[2]);
                curMax[1] = curMaxValue + input[1];
                max = curMax.clone();

                curMin[0] = Math.min(min[0], min[1]) + input[0];
                curMin[2] = Math.min(min[1], min[2]) + input[2];
                int curMinValue = Math.min(min[0], min[1]);
                curMinValue = Math.min(curMinValue, min[2]);
                curMin[1] = curMinValue + input[1];
                min = curMin.clone();
            }
        }
        int maxValue = Math.max(max[0], max[1]);
        maxValue = Math.max(maxValue, max[2]);
        int minValue = Math.min(min[0], min[1]);
        minValue = Math.min(minValue, min[2]);
        System.out.println(maxValue + " " + minValue);
    }//main end
}//class end
