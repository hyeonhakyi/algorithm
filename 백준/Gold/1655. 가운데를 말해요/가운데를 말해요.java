import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> L = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> R = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(L.size() == R.size()){
                L.add(x);
            }else{
                R.add(x);
            }

            if(!R.isEmpty() && L.peek() > R.peek()){
                int a = L.poll();
                int b = R.poll();
                L.add(b);
                R.add(a);
            }

            sb.append(L.peek()).append("\n");
        }

        System.out.println(sb.toString());
    }//main end
}//class end
