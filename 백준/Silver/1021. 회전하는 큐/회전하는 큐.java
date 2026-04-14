import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int answer = 0;

        for(int i = 0; i < m; i++){
            int target = Integer.parseInt(st.nextToken());

            int idx = deque.indexOf(target);
            int left = idx;
            int right = deque.size() - idx;

            if(left <= right){
                for(int j = 0; j < left; j++){
                    deque.addLast(deque.removeFirst());
                    answer++;
                }
            }else{
                for(int j = 0; j < right; j++){
                    deque.addFirst(deque.removeLast());
                    answer++;
                }
            }

            deque.removeFirst();
        }

        System.out.println(answer);
    }//main end
}//class end
