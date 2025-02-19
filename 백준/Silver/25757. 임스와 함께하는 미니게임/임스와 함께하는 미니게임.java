import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        HashSet<String> map = new HashSet<>();

        for(int i = 0; i < n; i++){
            map.add(br.readLine());
        }
        
        int playerCount = map.size();
        int groupSize = 0;

        if(game.equals("Y")){
            groupSize = 2;
        }else if(game.equals("F")){
            groupSize = 3;
        }else if(game.equals("O")){
            groupSize = 4;
        }

        System.out.println(playerCount / (groupSize - 1));
    }//main end
}//class end
