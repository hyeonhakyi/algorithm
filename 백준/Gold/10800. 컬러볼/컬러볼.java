import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Ball{
        int idx;
        int color;
        int size;
        public Ball(int idx,int color, int size){
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Ball[] ball = new Ball[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            ball[i] = new Ball(i,color,size);
        }

        Arrays.sort(ball,(a,b) -> a.size - b.size);

        int[] answer = new int[n];
        int[] colorSum = new int[n + 1];
        int totalSum = 0;

        int idx = 0;
        while(idx < n){
            int j = idx;

            while(j < n && ball[j].size == ball[idx].size){
                j++;
            }

            for(int i = idx; i < j; i++){
                Ball now = ball[i];
                answer[now.idx] = totalSum - colorSum[now.color];
            }

            for(int i = idx; i < j; i++){
                Ball now = ball[i];
                totalSum += now.size;
                colorSum[now.color] += now.size;
            }

            idx = j;
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb.toString());
    }//main end
}//class end
