import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        int[] count = new int[100001];

        Arrays.fill(time, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        time[n] = 0;
        count[n] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : new int[] {now - 1,now + 1, now * 2}){
                if(next < 0 || next > 100000) {
                    continue;
                }

                if(time[next] == -1) {
                    time[next] = time[now] + 1;
                    count[next] = count[now];
                    q.offer(next);
                } else if(time[next] == time[now] + 1) {
                    count[next] += count[now];
                }
            }
        }

        System.out.println(time[k]);
        System.out.println(count[k]);
    }//main end
}//class end
