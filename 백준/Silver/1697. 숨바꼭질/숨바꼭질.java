import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] check;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        check = new int[100001];

        if(n == k){
            System.out.println(0);
        }else{
            bfs(n);
        }
    }//main end

    private static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        check[n] = 0;

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i = 0; i < 3; i++){
                int next;
                if(i == 0){
                    next = temp + 1;
                }else if(i == 1){
                    next = temp - 1;
                }else{
                    next = temp * 2;
                }


                if(temp == k){
                    System.out.println(check[temp]);
                    return;
                }

                if(next >= 0 && next < check.length && check[next] == 0){
                    q.offer(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }//bfs end
}//class end
