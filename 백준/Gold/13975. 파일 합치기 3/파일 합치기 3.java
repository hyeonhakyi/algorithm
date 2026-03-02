import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T --> 0){
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> q = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                long num = Integer.parseInt(st.nextToken());
                q.offer(num);
            }

            long sum = 0;
            while(q.size() != 1){
                long fir = q.poll();
                long sec = q.poll();

                sum += (fir + sec);

                q.offer(fir + sec);
            }

            sb.append(sum).append("\n");
        }//testCase end

        System.out.println(sb.toString());
    }//main end
}//class end
