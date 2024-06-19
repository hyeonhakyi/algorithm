import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            int len = Integer.parseInt(br.readLine());

            String arr = br.readLine();
            Deque<Integer> deque = new LinkedList<>();
            for(String str : arr.substring(1,arr.length() - 1).split(",")){
                if(!str.equals("")){
                    deque.add(Integer.valueOf(str));
                }
            }

            System.out.println(ac(deque,s));
        }


    }//main end

    private static String ac(Deque<Integer> deque, String s) {
        boolean reverse = false;

        for(char c : s.toCharArray()){
            if(c == 'R'){
                reverse = !reverse;
            }else{
                if(deque.isEmpty()){
                    return "error";
                }
                if(reverse){
                    deque.removeLast();
                }else{
                    deque.removeFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder("[");
        while(!deque.isEmpty()){
            if(reverse){
                sb.append(deque.removeLast());
            }else{
                sb.append(deque.removeFirst());
            }
            if(!deque.isEmpty()){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }//ac end
}//class end
