import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] pos = new ArrayList[26];

            for(int i = 0; i < 26; i++){
                pos[i] = new ArrayList<>();
            }

            for(int i = 0; i < w.length(); i++){
                pos[w.charAt(i) - 'a'].add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            for(int i = 0; i < 26; i++){
                if(pos[i].size() < k) continue;
                for(int j = 0; j <= pos[i].size() - k; j++){
                    int start = pos[i].get(j);
                    int end = pos[i].get(j + k - 1);
                    int len = end - start +1;
                    minLen = Math.min(minLen, len);
                    maxLen = Math.max(maxLen, len);
                }
            }

            if(maxLen == -1){
                System.out.println(-1);
            }else{
                System.out.println(minLen + " " + maxLen);
            }
        }//t end
    }//main end
}//class end
