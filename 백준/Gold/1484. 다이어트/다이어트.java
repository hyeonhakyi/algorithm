import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());

        int x = 1;
        int y = 1;
        StringBuilder sb = new StringBuilder();
        while(x <= 100000){
            long diff = (x * x) - (y * y);

            if(diff < g){
                x++;
            }else if(diff > g){
                y++;
            }else if(diff == g){
                sb.append(x).append("\n");
                x++;
            }
        }

        if(sb.length() == 0){
            System.out.println(-1);
        }else{
            System.out.println(sb.toString());
        }
    }//main end
}//class end
