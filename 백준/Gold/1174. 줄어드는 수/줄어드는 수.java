import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= 9; i++){
            dfs(i, i);
        }

        Collections.sort(list);

        if(n > list.size()){
            System.out.println(-1);
        }else{
            System.out.println(list.get(n - 1));
        }
    }//main end

    private static void dfs(int last,long value){
        list.add(value);

        for(int i = 0; i < last; i++){
            dfs(i, value * 10 + i);
        }
    }//dfs end
}//class end
