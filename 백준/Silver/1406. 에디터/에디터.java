import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Character> left = new ArrayDeque<>();
        ArrayDeque<Character> right = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++){
            left.add(str.charAt(i));
        }

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("L")){
                if(!left.isEmpty()){
                    right.addFirst(left.removeLast());
                }
            }else if(cmd.equals("D")){
                if(!right.isEmpty()){
                    left.addLast(right.removeFirst());
                }
            }else if(cmd.equals("B")){
                if(!left.isEmpty()){
                    left.removeLast();
                }
            }else{
                char value = st.nextToken().charAt(0);
                left.addLast(value);
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!left.isEmpty()){
            sb.append(left.removeFirst());
        }

        while(!right.isEmpty()){
            sb.append(right.removeFirst());
        }

        System.out.println(sb.toString());
    }//main end
}//class end
