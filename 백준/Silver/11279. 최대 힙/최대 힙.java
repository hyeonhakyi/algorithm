import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    private static class Node{
        int number;
        public Node(int number){
            this.number = number;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            if(m == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }else{
                pq.add(m);
            }
        }
    }//main end
}//class end
