import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n , w , l , sum, time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> brigeQ = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        for(int i = 0; i < w; i++){
            brigeQ.offer(0);
        }

        sum = 0;
        time = 0;

        st = new StringTokenizer(br.readLine());
        int truck = Integer.parseInt(st.nextToken());
        while(true){
            time++;

            sum-=brigeQ.poll();
            if(sum + truck <=l){
                brigeQ.offer(truck);
                sum+=truck;
                if(--n == 0){
                    break;
                }
                truck = Integer.parseInt(st.nextToken());
            }else{
                brigeQ.offer(0);
            }
        }
        time += brigeQ.size();
        System.out.println(time);
    }
}
