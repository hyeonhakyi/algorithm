import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bom = br.readLine();
        int bomSize = bom.length();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
            if(st.size() >= bomSize){
                boolean check = true;

                for(int j = 0; j < bomSize; j++) {
                    if(st.get(st.size() - bomSize + j) != bom.charAt(j)){
                        check = false;
                        break;
                    }
                }
                if(check){
                    for(int j = 0; j < bomSize; j++) {
                        st.pop();
                    }
                }
            }
        }
        if(st.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            for(Character c : st){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }//main end
}//class end
