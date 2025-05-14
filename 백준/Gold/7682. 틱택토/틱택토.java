import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String line = br.readLine();
            if(line.equals("end")) break;

            map = new char[3][3];
            int xCnt = 0;
            int oCnt = 0;

            for(int i = 0; i < 9; i++){
                map[i / 3][i % 3] = line.charAt(i);
                if(line.charAt(i) == 'O') oCnt++;
                if(line.charAt(i) == 'X') xCnt++;
            }

            if(isValid(xCnt,oCnt)){
                System.out.println("valid");
            }else{
                System.out.println("invalid");
            }
        }//while end
    }//main end

    public static boolean isValid(int xCnt, int oCnt){
        boolean xWin = win('X');
        boolean oWin = win('O');

        if(xCnt == oCnt + 1 && xWin && !oWin) return true;
        if(xCnt == oCnt && oWin && !xWin) return true;
        if(xCnt == 5 && oCnt == 4 && !xWin && !oWin) return true;
        
        return false;
    }//isValid end

    static boolean win(char c){
        for(int i = 0; i < 3; i++){
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c) return true;
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c) return true;
        }
        
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
        if(map[0][2] == c && map[1][1] == c && map[2][0] == c) return true;
        
        return false;
    }//win end
}//class end
