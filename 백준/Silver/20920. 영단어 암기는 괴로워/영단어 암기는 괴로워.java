import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            String str = br.readLine();

            if(str.length() < m) continue;

            map.put(str,map.getOrDefault(str,0) + 1);
        }

        List<String> words = new ArrayList<>(map.keySet());

        words.sort((a,b) -> {
            if(!map.get(a).equals(map.get(b))){
                return map.get(b) - map.get(a);
            }

            if(a.length() != b.length()){
                return b.length() - a.length();
            }

            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(String s : words){
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }//main end
}//class end
