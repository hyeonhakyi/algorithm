import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int input = -1;

            switch (command) {
            case "add":
                set.add(Integer.parseInt(st.nextToken()));
                break;
            case "remove":
                set.remove(Integer.parseInt(st.nextToken()));
                break;
            case "check":
                input = Integer.parseInt(st.nextToken());
                if(set.contains(input)){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append("\n");
                break;
            case "toggle":
                input = Integer.parseInt(st.nextToken());
                if(set.contains(input)){
                    set.remove(input);
                }else{
                    set.add(input);
                }
                break;
            case "all":
                set = new HashSet<>();
                for(int j = 1; j <= 20; j++){
                    set.add(j);
                }
                break;
            case "empty":
                set.clear();
                break;
            }
        }
        System.out.println(sb.toString());
    }//main end
}//class end
