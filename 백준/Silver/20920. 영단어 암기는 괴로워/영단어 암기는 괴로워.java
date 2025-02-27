import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            String str = br.readLine();
            if(str.length() >= m){
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((w1, w2) -> {
            if(!map.get(w1).equals(map.get(w2))){
                return map.get(w2) - map.get(w1);
            }
            if(w1.length() != w2.length()){
                return w2.length()-w1.length();
            }
            return w1.compareTo(w2);
        });
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String word : list){
            bw.write(word);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }//main end
}//class end
