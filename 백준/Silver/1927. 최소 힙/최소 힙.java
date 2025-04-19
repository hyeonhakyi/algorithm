import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < x; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a!=0){
                pq.add(a);
            }else if(a == 0 && pq.isEmpty()){
                System.out.println(0);
            }else{
                System.out.println(pq.poll());
            }
        }

    }//main end
}//class end
