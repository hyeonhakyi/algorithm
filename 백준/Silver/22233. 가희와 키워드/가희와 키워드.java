import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for(int i = 0; i < m; i++) {
            String line = br.readLine();
            String[] keywords = line.split(",");
            
            for(String keyword : keywords) {
                set.remove(keyword);
            }
            
            sb.append(set.size()).append("\n");
        }

        System.out.println(sb.toString());
    }//main end
}//class end
