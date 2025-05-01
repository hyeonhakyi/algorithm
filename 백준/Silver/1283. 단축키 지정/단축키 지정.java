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
        Set<Character> set = new HashSet<Character>();


        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            String[] words = new String[st.countTokens()];
            for (int j = 0; j < words.length; j++) {
                words[j] = st.nextToken();
            }

            boolean assigned = false;

            for(int j = 0; j < words.length; j++) {
                char ch = Character.toLowerCase(words[j].charAt(0));
                if(!set.contains(ch)) {
                    set.add(ch);
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    assigned = true;
                    break;
                }
            }


            if(!assigned){
                outer : for(int j = 0; j < words.length; j++) {
                    for(int k = 0; k < words[j].length(); k++) {
                        char ch = Character.toLowerCase(words[j].charAt(k));
                        if(!set.contains(ch)) {
                            set.add(ch);
                            words[j] = words[j].substring(0,k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k+1);
                            break outer;
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < words.length; j++) {
                sb.append(words[j]);
                if(j < words.length - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }//main end
}//class end
