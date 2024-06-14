import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();


        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            if(map.get(s) != null){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }

        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            if(map.get(s) != null){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) != 1) {
                list.add(key);
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append('\n');
        for(String name : list) {
            sb.append(name).append('\n');
        }

        System.out.println(sb);
    }//main end
}//class end
